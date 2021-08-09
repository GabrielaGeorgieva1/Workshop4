package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Truck;
import com.telerikacademy.oop.dealership.models.enums.VehicleType;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {

    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);
    private static final int WHEEL_ON_TRUCK = 8;

    private int weightCapacity;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(VehicleType.TRUCK, make, model, price, WHEEL_ON_TRUCK);
        setWeightCapacity(weightCapacity);
    }

    public void setWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity
                , WEIGHT_CAP_MIN
                , WEIGHT_CAP_MAX
                , WEIGHT_CAP_ERR);
    }


    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s%nWeight Category:%s", super.toString(), getWeightCapacity());
    }
}
