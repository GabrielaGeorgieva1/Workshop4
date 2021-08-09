package com.telerikacademy.oop.dealership.models;

import static java.lang.String.format;

public class TruckImpl {
    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);

    //TODO
}
