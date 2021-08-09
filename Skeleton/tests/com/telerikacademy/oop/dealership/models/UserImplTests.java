package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.enums.UserRole;
import com.telerikacademy.oop.dealership.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.dealership.models.UserImpl.*;
import static com.telerikacademy.oop.dealership.utils.TestUtilities.initializeStringWithSize;

public class UserImplTests {

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {USERNAME_LEN_MIN - 1, USERNAME_LEN_MAX + 1})
    public void should_throwException_when_usernameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new UserImpl(
                        initializeStringWithSize(testLength),
                        TestData.User.VALID_FIRST_NAME,
                        TestData.User.VALID_LAST_NAME,
                        TestData.User.VALID_PASSWORD,
                        UserRole.NORMAL));
    }

    @Test
    public void Constructor_ShouldThrow_WhenUsernameDoesNotMatchPattern() {
        //Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new UserImpl("U$$ernam3",
                        "firstName",
                        "lastName",
                        "password",
                        UserRole.NORMAL));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {FIRSTNAME_LEN_MIN - 1, FIRSTNAME_LEN_MAX + 1})
    public void should_throwException_when_firstNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new UserImpl(
                        TestData.User.VALID_USERNAME,
                        initializeStringWithSize(testLength),
                        TestData.User.VALID_LAST_NAME,
                        TestData.User.VALID_PASSWORD,
                        UserRole.NORMAL));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {LASTNAME_LEN_MIN - 1, LASTNAME_LEN_MAX + 1})
    public void should_throwException_when_lastNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new UserImpl(
                        TestData.User.VALID_USERNAME,
                        TestData.User.VALID_FIRST_NAME,
                        initializeStringWithSize(testLength),
                        TestData.User.VALID_PASSWORD,
                        UserRole.NORMAL));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {PASSWORD_LEN_MIN - 1, PASSWORD_LEN_MAX + 1})
    public void should_throwException_when_passwordLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new UserImpl(
                        TestData.User.VALID_USERNAME,
                        TestData.User.VALID_FIRST_NAME,
                        TestData.User.VALID_LAST_NAME,
                        initializeStringWithSize(testLength),
                        UserRole.NORMAL));
    }

    @Test
    public void Constructor_ShouldThrow_WhenPasswordDoesNotMatchPattern() {
        //Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new UserImpl("Username",
                        "firstName",
                        "lastName",
                        "Pa-$$_w0rD",
                        UserRole.NORMAL));
    }

}
