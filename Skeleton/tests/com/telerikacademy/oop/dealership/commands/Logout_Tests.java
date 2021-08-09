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

import java.util.ArrayList;

import static com.telerikacademy.oop.dealership.utils.TestData.User.*;
import static com.telerikacademy.oop.dealership.utils.TestData.User.VALID_PASSWORD;

public class Logout_Tests {
    private VehicleDealershipRepository vehicleDealershipRepository;
    private CommandFactory commandFactory;

    @BeforeEach
    public void before() {
        commandFactory = new CommandFactoryImpl();
        vehicleDealershipRepository = new VehicleDealershipRepositoryImpl();
    }

    @Test
    public void execute_ShouldLogoutUser() {
        // Arrange
        User userToLogIn = new UserImpl(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD, UserRole.NORMAL);
        vehicleDealershipRepository.login(userToLogIn);
        Command logout = commandFactory.createCommandFromCommandName("logout", vehicleDealershipRepository);

        // Act
        logout.execute(new ArrayList<>());

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> vehicleDealershipRepository.getLoggedInUser());
    }
}
