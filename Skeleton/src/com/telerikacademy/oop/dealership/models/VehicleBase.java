package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Comment;
import com.telerikacademy.oop.dealership.models.contracts.Vehicle;
import com.telerikacademy.oop.dealership.models.enums.VehicleType;
import com.telerikacademy.oop.dealership.utils.FormattingHelpers;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleBase implements Vehicle {
    private final VehicleType type;
    private String make;
    private String model;
    private double price;
    private int wheel;
    private List<Comment> comments;


    public VehicleBase(VehicleType type, String make, String model, double price, int wheel) {
        this.type = type;
        setMake(make);
        setModel(model);
        setPrice(price);
        this.wheel = wheel;
    }

    private void setMake(String make) {
        ValidationHelpers.validateStringRange(make
                , ModelConstants.MAKE_NAME_LEN_MIN
                , ModelConstants.MAKE_NAME_LEN_MAX
                , ModelConstants.MAKE_NAME_LEN_ERR);
    }

    private void setModel(String model) {
        ValidationHelpers.validateStringRange(model
                , ModelConstants.MODEL_NAME_LEN_MIN
                , ModelConstants.MODEL_NAME_LEN_MAX
                , ModelConstants.MODEL_NAME_LEN_ERR);
    }

    private void setPrice(double price) {
        ValidationHelpers.validateDecimalRange(price
                , ModelConstants.PRICE_VAL_MIN
                , ModelConstants.PRICE_VAL_MAX
                , ModelConstants.PRICE_VAL_ERR);
    }


    @Override
    public double getPrice() {
        return price;
    }


    @Override
    public int getWheels() {
        return wheel;
    }


    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);

    }

    @Override
    public void removeComment(Comment comment) {
        if (comments.contains(comment)) {
            comments.remove(comment);
        } else {
            throw new IllegalArgumentException("This comment is not found");
        }

    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public String toString() {
        int count = 0;
        count++;
        return String.format("%s. %s:\n" +
                        "Make: %s\n" +
                        "Model: %s\n" +
                        "Wheels: %s\n" +
                        "Price: $%s\n", count, getType(), getMake(), getModel(), getWheels()
                , FormattingHelpers.removeTrailingZerosFromDouble(price));

    }
}
