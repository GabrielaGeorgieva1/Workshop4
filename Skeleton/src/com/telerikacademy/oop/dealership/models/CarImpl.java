package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Car;
import com.telerikacademy.oop.dealership.models.enums.VehicleType;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {

    public static final int CAR_SEATS_MIN = 1;
    public static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);
    private static final int WHEEL_ON_TRUCK = 4;

    private int seats;


    public CarImpl(String make, String model, double price, int seats) {
        super(VehicleType.CAR, make, model, price,WHEEL_ON_TRUCK);
        setSeats(seats);
    }

    private void setSeats(int seats) {
        ValidationHelpers.validateIntRange(seats
                , CAR_SEATS_MIN
                , CAR_SEATS_MAX
                , CAR_SEATS_ERR);
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public String toString() {
        return String.format("%s%nSeats:%s", super.toString(), getSeats());
    }
}