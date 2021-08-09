package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Car;
import com.telerikacademy.oop.dealership.models.contracts.Vehicle;
import com.telerikacademy.oop.dealership.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.dealership.models.ModelConstants.*;
import static com.telerikacademy.oop.dealership.utils.TestUtilities.initializeStringWithSize;


public class CarImpl_Tests {


    @Test
    public void CarImpl_ShouldImplementCarInterface() {
        CarImpl car = new CarImpl("make", "model", 100, 4);
        // Assert
        Assertions.assertTrue(car instanceof Car);
    }

    @Test
    public void CarImpl_ShouldImplementVehicleInterface() {
        CarImpl car = new CarImpl("make", "model", 100, 4);
        // Assert
        Assertions.assertTrue(car instanceof Vehicle);
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {MAKE_NAME_LEN_MIN - 1, MAKE_NAME_LEN_MAX + 1})
    public void should_throwException_when_makeNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CarImpl(
                        initializeStringWithSize(testLength),
                        TestData.VehicleBase.VALID_MODEL,
                        TestData.VehicleBase.VALID_PRICE,
                        CarImpl.CAR_SEATS_MIN));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {MODEL_NAME_LEN_MIN - 1, MODEL_NAME_LEN_MAX + 1})
    public void should_throwException_when_modelNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CarImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        initializeStringWithSize(testLength),
                        TestData.VehicleBase.VALID_PRICE,
                        CarImpl.CAR_SEATS_MIN));
    }

    @ParameterizedTest(name = "with price: {0}")
    @ValueSource(ints = {-1, 1000001})
    public void should_throwException_when_priceIsInvalid(int testPrice) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CarImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        TestData.VehicleBase.VALID_MODEL,
                        testPrice,
                        CarImpl.CAR_SEATS_MIN));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {CarImpl.CAR_SEATS_MIN - 1, CarImpl.CAR_SEATS_MAX + 1, -1})
    public void should_throwException_when_seatsValueIsInvalidOrNegative(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CarImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        TestData.VehicleBase.VALID_MODEL,
                        TestData.VehicleBase.VALID_PRICE,
                        testLength));
    }
}
