package com.telerikacademy.oop.dealership.commands;

import com.telerikacademy.oop.dealership.commands.contracts.Command;
import com.telerikacademy.oop.dealership.core.CommandFactoryImpl;
import com.telerikacademy.oop.dealership.core.VehicleDealershipRepositoryImpl;
import com.telerikacademy.oop.dealership.core.contracts.CommandFactory;
import com.telerikacademy.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.telerikacademy.oop.dealership.models.UserImpl;
import com.telerikacademy.oop.dealership.models.contracts.User;
import com.telerikacademy.oop.dealership.models.enums.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.telerikacademy.oop.dealership.utils.TestData.User.*;
import static com.telerikacademy.oop.dealership.utils.TestData.User.VALID_PASSWORD;

public class Login_Tests {
    private VehicleDealershipRepository vehicleDealershipRepository;
    private CommandFactory commandFactory;

    @BeforeEach
    public void before() {
        this.commandFactory = new CommandFactoryImpl();
        this.vehicleDealershipRepository = new VehicleDealershipRepositoryImpl();
    }

    @Test
    public void execute_ShouldLoginUser_WhenUserNotLoggedIn() {
        // Arrange
        User userToLogIn = new UserImpl(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD, UserRole.NORMAL);
        vehicleDealershipRepository.addUser(userToLogIn);
        Command login = commandFactory.createCommandFromCommandName("Login", vehicleDealershipRepository);
        List<String> params = List.of(userToLogIn.getUsername(), userToLogIn.getPassword());

        // Act
        login.execute(params);

        // Assert
        Assertions.assertEquals(userToLogIn.getUsername(), vehicleDealershipRepository.getLoggedInUser().getUsername());
    }

    @Test
    public void execute_ShouldThrow_WhenPasswordIsWrong() {
        // Arrange
        User userToLogIn = new UserImpl(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD, UserRole.NORMAL);
        vehicleDealershipRepository.addUser(userToLogIn);
        Command login = commandFactory.createCommandFromCommandName("Login", vehicleDealershipRepository);
        List<String> params = List.of(userToLogIn.getUsername(), "WRONGPASSWORD");

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> login.execute(params));
    }

    @Test
    public void execute_ShouldThrow_WhenUserDoesNotExists() {
        // Arrange
        Command login = commandFactory.createCommandFromCommandName("Login", vehicleDealershipRepository);
        List<String> params = List.of(VALID_USERNAME, VALID_PASSWORD);

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> login.execute(params));
    }

    @Test
    public void execute_ShouldThrow_WhenUserAlreadyLoggedIn() {
        // Arrange
        User userToLogIn = new UserImpl(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD, UserRole.NORMAL);
        vehicleDealershipRepository.addUser(userToLogIn);
        Command login = commandFactory.createCommandFromCommandName("Login", vehicleDealershipRepository);
        List<String> params = List.of(userToLogIn.getUsername(), userToLogIn.getPassword());

        // Act
        login.execute(params);

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> login.execute(params));
    }
}
