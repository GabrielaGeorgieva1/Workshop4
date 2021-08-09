package com.telerikacademy.oop.dealership.utils;

import static com.telerikacademy.oop.dealership.models.CarImpl.CAR_SEATS_MIN;
import static com.telerikacademy.oop.dealership.models.CommentImpl.CONTENT_LEN_MIN;
import static com.telerikacademy.oop.dealership.models.ModelConstants.*;
import static com.telerikacademy.oop.dealership.models.MotorcycleImpl.CATEGORY_LEN_MIN;
import static com.telerikacademy.oop.dealership.models.TruckImpl.WEIGHT_CAP_MIN;
import static com.telerikacademy.oop.dealership.models.UserImpl.*;
import static com.telerikacademy.oop.dealership.models.VehicleBase.*;

public class TestData {

    public static class VehicleBase {
        public static final String VALID_MAKE = TestUtilities.initializeStringWithSize(MAKE_NAME_LEN_MIN + 1);
        public static final String VALID_MODEL = TestUtilities.initializeStringWithSize(MODEL_NAME_LEN_MIN + 1);
        public static final double VALID_PRICE = PRICE_VAL_MIN + 1;
    }

    public static class Motorcycle {
        public static final String VALID_CATEGORY = TestUtilities.initializeStringWithSize(CATEGORY_LEN_MIN + 1);
    }

    public static class Truck {
        public static final int VALID_WEIGHT_CAP = WEIGHT_CAP_MIN + 1;
    }

    public static class Car {
        public static final int VALID_SEATS = CAR_SEATS_MIN + 1;
    }

    public static class Comment {
        public static final String VALID_CONTENT = TestUtilities.initializeStringWithSize(CONTENT_LEN_MIN + 1);
    }

    public static class User {
        public static final String VALID_USERNAME = TestUtilities.initializeStringWithSize(USERNAME_LEN_MIN + 1);
        public static final String VALID_PASSWORD = TestUtilities.initializeStringWithSize(PASSWORD_LEN_MIN + 1);
        public static final String VALID_FIRST_NAME = TestUtilities.initializeStringWithSize(FIRSTNAME_LEN_MIN + 1);
        public static final String VALID_LAST_NAME = TestUtilities.initializeStringWithSize(LASTNAME_LEN_MIN + 1);
    }
}