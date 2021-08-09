package com.telerikacademy.oop.dealership.models;

import static java.lang.String.format;

public class CarImpl {

    public static final int CAR_SEATS_MIN = 1;
    public static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);

    //TODO
}
