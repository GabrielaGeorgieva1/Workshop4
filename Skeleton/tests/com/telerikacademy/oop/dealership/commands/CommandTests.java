package com.telerikacademy.oop.dealership.commands;


import com.telerikacademy.oop.dealership.commands.contracts.Command;
import com.telerikacademy.oop.dealership.core.CommandFactoryImpl;
import com.telerikacademy.oop.dealership.core.VehicleDealershipRepositoryImpl;
import com.telerikacademy.oop.dealership.core.contracts.CommandFactory;
import com.telerikacademy.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.telerikacademy.oop.dealership.models.contracts.Car;
import com.telerikacademy.oop.dealership.models.contracts.Comment;
import com.telerikacademy.oop.dealership.models.contracts.Motorcycle;
import com.telerikacademy.oop.dealership.models.contracts.Truck;
import com.telerikacademy.oop.dealership.models.contracts.User;
import com.telerikacademy.oop.dealership.models.enums.VehicleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.telerikacademy.oop.dealership.utils.Factory.*;
import static com.telerikacademy.oop.dealership.utils.TestData.Car.VALID_SEATS;
import static com.telerikacademy.oop.dealership.utils.TestData.Comment.VALID_CONTENT;
import static com.telerikacademy.oop.dealership.utils.TestData.Motorcycle.VALID_CATEGORY;
import static com.telerikacademy.oop.dealership.utils.TestData.Truck.VALID_WEIGHT_CAP;
import static com.telerikacademy.oop.dealership.utils.TestData.VehicleBase.*;

public class CommandTests {

    private VehicleDealershipRepository vehicleDealershipRepository = new VehicleDealershipRepositoryImpl();
    private CommandFactory commandFactory = new CommandFactoryImpl();
    private User user = createNormalUser();

    @BeforeEach
    public void before() {
        commandFactory = new CommandFactoryImpl();
        vehicleDealershipRepository = new VehicleDealershipRepositoryImpl();
        user = createNormalUser();
        vehicleDealershipRepository.addUser(user);
        vehicleDealershipRepository.login(user);
    }

    @Test
    public void createCar_ShouldCreate_WhenInputIsValid() {
        // Act
        Command createVehicle = commandFactory.createCommandFromCommandName("AddVehicle", vehicleDealershipRepository);
        Car testCar = createCar();
        List<String> params = List.of(String.valueOf(VehicleType.CAR), VALID_MAKE, VALID_MODEL, String.valueOf(VALID_PRICE), String.valueOf(VALID_SEATS));

        // Act
        createVehicle.execute(params);

        //Assert
        Car toCompare = (Car) vehicleDealershipRepository.getLoggedInUser().getVehicles().get(0);
        Assertions.assertEquals(testCar.getMake(), toCompare.getMake());
        Assertions.assertEquals(testCar.getSeats(), toCompare.getSeats());

    }

    @Test
    public void createMotorcycle_ShouldCreate_WhenInputIsValid() {
        // Act
        Command createVehicle = commandFactory.createCommandFromCommandName("AddVehicle", vehicleDealershipRepository);
        Motorcycle testMotorcycle = createMotorcycle();
        List<String> params = List.of(VehicleType.MOTORCYCLE.toString(), VALID_MAKE, VALID_MODEL, String.valueOf(VALID_PRICE), VALID_CATEGORY);

        // Act
        createVehicle.execute(params);

        //Assert
        Motorcycle toCompare = (Motorcycle) vehicleDealershipRepository.getLoggedInUser().getVehicles().get(0);
        Assertions.assertEquals(testMotorcycle.getMake(), toCompare.getMake());
        Assertions.assertEquals(testMotorcycle.getCategory(), toCompare.getCategory());

    }

    @Test
    public void createTruck_ShouldCreate_WhenInputIsValid() {
        // Act
        Command createVehicle = commandFactory.createCommandFromCommandName("AddVehicle", vehicleDealershipRepository);
        Truck testTruck = createTruck();
        List<String> params = List.of(VehicleType.TRUCK.toString(), VALID_MAKE, VALID_MODEL, String.valueOf(VALID_PRICE), String.valueOf(VALID_WEIGHT_CAP));

        // Act
        createVehicle.execute(params);

        //Assert
        Truck toCompare = (Truck) vehicleDealershipRepository.getLoggedInUser().getVehicles().get(0);
        Assertions.assertEquals(testTruck.getMake(), toCompare.getMake());
        Assertions.assertEquals(testTruck.getWeightCapacity(), toCompare.getWeightCapacity());

    }

    @Test
    public void createComment_ShouldCreate_WhenInputIsValid() {
        Command createVehicle = commandFactory.createCommandFromCommandName("AddVehicle", vehicleDealershipRepository);
        List<String> params = List.of(VehicleType.TRUCK.toString(), VALID_MAKE, VALID_MODEL, String.valueOf(VALID_PRICE), String.valueOf(VALID_WEIGHT_CAP));
        createVehicle.execute(params);

        // Act
        Command addComment = commandFactory.createCommandFromCommandName("AddComment",
                vehicleDealershipRepository);
        Comment testComment = createComment(user);
        List<String> params2 = List.of(VALID_CONTENT, user.getUsername(), "1");

        // Act
        addComment.execute(params2);

        //Assert
        Comment toCompare = vehicleDealershipRepository.getLoggedInUser().getVehicles().get(0).getComments().get(0);
        Assertions.assertEquals(toCompare.getContent(), testComment.getContent());
        Assertions.assertEquals(toCompare.getAuthor(), testComment.getAuthor());
    }


}
