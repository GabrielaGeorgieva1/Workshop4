package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Comment;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CommentImpl implements Comment {

    public static final int CONTENT_LEN_MIN = 3;
    public static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    private String content;
    private String author;


    public CommentImpl(String content, String author) {
        setContent(content);
        this.author = author;
    }

    public void setContent(String content) {
        ValidationHelpers.validateStringRange(content
                , CONTENT_LEN_MIN
                , CONTENT_LEN_MAX
                , CONTENT_LEN_ERR);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

}
