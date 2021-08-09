package com.telerikacademy.oop.dealership.commands;

import com.telerikacademy.oop.dealership.commands.contracts.Command;
import com.telerikacademy.oop.dealership.core.CommandFactoryImpl;
import com.telerikacademy.oop.dealership.core.VehicleDealershipRepositoryImpl;
import com.telerikacademy.oop.dealership.core.contracts.CommandFactory;
import com.telerikacademy.oop.dealership.core.contracts.VehicleDealershipRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.telerikacademy.oop.dealership.utils.TestData.User.*;

public class RegisterUser_Tests {

    private VehicleDealershipRepository vehicleDealershipRepository;
    private CommandFactory commandFactory;

    @BeforeEach
    public void before() {
        this.commandFactory = new CommandFactoryImpl();
        this.vehicleDealershipRepository = new VehicleDealershipRepositoryImpl();
    }

    @Test
    public void createUser_ShouldCreate_WhenInputIsValid() {
        // Arrange
        Command createCommand = commandFactory.createCommandFromCommandName("RegisterUser",
                vehicleDealershipRepository);
        List<String> params = List.of(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD);

        // Act
        createCommand.execute(params);

        //Assert
        Assertions.assertEquals(vehicleDealershipRepository.getUsers().size(), 1);
        Assertions.assertEquals(vehicleDealershipRepository.getUsers().get(0).getUsername(), VALID_USERNAME);

    }

    @Test
    public void Execute_ShouldThrow_WhenUserAlreadyExist() {
        // Arrange
        Command registerUser = commandFactory.createCommandFromCommandName("registeruser", vehicleDealershipRepository);
        List<String> params = List.of(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD);

        // Act
        registerUser.execute(params);

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> registerUser.execute(params));
    }
}
