package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Truck;
import com.telerikacademy.oop.dealership.models.contracts.Vehicle;
import com.telerikacademy.oop.dealership.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.dealership.models.ModelConstants.*;
import static com.telerikacademy.oop.dealership.utils.TestUtilities.initializeStringWithSize;

public class TruckImpl_Tests {

    @Test
    public void TruckImpl_ShouldImplementTruckInterface() {
        TruckImpl truck = new TruckImpl("make", "model", 100, 10);
        Assertions.assertTrue(truck instanceof Truck);
    }

    @Test
    public void TruckImpl_ShouldImplementVehicleInterface() {
        TruckImpl truck = new TruckImpl("make", "model", 100, 10);
        Assertions.assertTrue(truck instanceof Vehicle);
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {MAKE_NAME_LEN_MIN - 1, MAKE_NAME_LEN_MAX + 1})
    public void should_throwException_when_makeNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TruckImpl(
                        initializeStringWithSize(testLength),
                        TestData.VehicleBase.VALID_MODEL,
                        TestData.VehicleBase.VALID_PRICE,
                        TestData.Truck.VALID_WEIGHT_CAP));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {MODEL_NAME_LEN_MIN - 1, MODEL_NAME_LEN_MAX + 1})
    public void should_throwException_when_modelNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TruckImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        initializeStringWithSize(testLength),
                        TestData.VehicleBase.VALID_PRICE,
                        TestData.Truck.VALID_WEIGHT_CAP));
    }

    @ParameterizedTest(name = "with price: {0}")
    @ValueSource(ints = {-1, 1000001})
    public void should_throwException_when_priceIsInvalid(int testPrice) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TruckImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        TestData.VehicleBase.VALID_MODEL,
                        testPrice,
                        TestData.Truck.VALID_WEIGHT_CAP));
    }

    @ParameterizedTest(name = "with price: {0}")
    @ValueSource(ints = {TestData.Truck.VALID_WEIGHT_CAP - 2, TestData.Truck.VALID_WEIGHT_CAP + 100, -1})
    public void should_throwException_when_weightIsInvalid(int testWeight) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new TruckImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        TestData.VehicleBase.VALID_MODEL,
                        TestData.VehicleBase.VALID_PRICE,
                        testWeight));
    }
}
