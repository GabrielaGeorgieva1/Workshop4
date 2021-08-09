package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Comment;
import com.telerikacademy.oop.dealership.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.dealership.models.CommentImpl.CONTENT_LEN_MAX;
import static com.telerikacademy.oop.dealership.models.CommentImpl.CONTENT_LEN_MIN;
import static com.telerikacademy.oop.dealership.utils.TestUtilities.initializeStringWithSize;

public class CommentImpl_Tests {

    @Test
    public void CommentImpl_ShouldImplementCommentInterface() {
        CommentImpl comment = new CommentImpl("content", "author");
        Assertions.assertTrue(comment instanceof Comment);
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {CONTENT_LEN_MIN - 1, CONTENT_LEN_MAX + 1})
    public void should_throwException_when_modelNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CommentImpl(
                        initializeStringWithSize(testLength),
                        TestData.User.VALID_USERNAME));
    }
}
