package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Motorcycle;
import com.telerikacademy.oop.dealership.models.enums.VehicleType;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {

    public static final int CATEGORY_LEN_MIN = 3;
    public static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);
    private static final int WHEEL_ON_MOTORCYCLE = 2;

    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(VehicleType.MOTORCYCLE, make, model, price, WHEEL_ON_MOTORCYCLE);
        setCategory(category);
    }

    public void setCategory(String category) {
        ValidationHelpers.validateStringRange(category
                , CATEGORY_LEN_MIN
                , CATEGORY_LEN_MAX
                , CATEGORY_LEN_ERR);
    }

    @Override
    public String getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return String.format("%s%nCategory:%s", super.toString(), getCategory());
    }
}
