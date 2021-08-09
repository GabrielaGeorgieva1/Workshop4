package com.telerikacademy.oop.dealership.utils;

import com.telerikacademy.oop.dealership.models.*;
import com.telerikacademy.oop.dealership.models.enums.UserRole;
import com.telerikacademy.oop.dealership.models.contracts.*;

import static com.telerikacademy.oop.dealership.utils.TestData.Car.VALID_SEATS;
import static com.telerikacademy.oop.dealership.utils.TestData.Comment.VALID_CONTENT;
import static com.telerikacademy.oop.dealership.utils.TestData.Motorcycle.VALID_CATEGORY;
import static com.telerikacademy.oop.dealership.utils.TestData.Truck.VALID_WEIGHT_CAP;
import static com.telerikacademy.oop.dealership.utils.TestData.User.*;
import static com.telerikacademy.oop.dealership.utils.TestData.User.VALID_PASSWORD;
import static com.telerikacademy.oop.dealership.utils.TestData.VehicleBase.*;

public class Factory {

    public static Car createCar() {
        return new CarImpl(VALID_MAKE, VALID_MODEL, VALID_PRICE, VALID_SEATS);
    }

    public static User createNormalUser() {
        return new UserImpl(VALID_USERNAME, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PASSWORD, UserRole.NORMAL);
    }

    public static Motorcycle createMotorcycle() {
        return new MotorcycleImpl(VALID_MAKE, VALID_MODEL, VALID_PRICE, VALID_CATEGORY);
    }

    public static Truck createTruck() {
        return new TruckImpl(VALID_MAKE, VALID_MODEL, VALID_PRICE, VALID_WEIGHT_CAP);
    }

    public static Comment createComment(User user) {
        return new CommentImpl(VALID_CONTENT, user.getUsername());
    }

}
