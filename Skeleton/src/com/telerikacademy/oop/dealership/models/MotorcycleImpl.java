package com.telerikacademy.oop.dealership.models;

import static java.lang.String.format;

public class MotorcycleImpl {

    public static final int CATEGORY_LEN_MIN = 3;
    public static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    //TODO
}
