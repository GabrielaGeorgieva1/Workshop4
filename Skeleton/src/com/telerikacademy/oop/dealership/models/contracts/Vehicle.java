package com.telerikacademy.oop.dealership.models.contracts;

import com.telerikacademy.oop.dealership.models.enums.VehicleType;

public interface Vehicle {

    int getWheels();

    VehicleType getType();

    String getMake();

    String getModel();

    void addComment(Comment comment);

    void removeComment(Comment comment);

}
