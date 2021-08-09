package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Motorcycle;
import com.telerikacademy.oop.dealership.models.contracts.Vehicle;
import com.telerikacademy.oop.dealership.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.dealership.models.ModelConstants.*;
import static com.telerikacademy.oop.dealership.models.MotorcycleImpl.CATEGORY_LEN_MAX;
import static com.telerikacademy.oop.dealership.models.MotorcycleImpl.CATEGORY_LEN_MIN;
import static com.telerikacademy.oop.dealership.utils.TestUtilities.initializeStringWithSize;

public class MotorcycleImpl_Tests {

    @Test
    public void MotorcycleImpl_ShouldImplementMotorcycleInterface() {
        MotorcycleImpl motorcycle = new MotorcycleImpl("make", "model", 100, "category");
        Assertions.assertTrue(motorcycle instanceof Motorcycle);
    }

    @Test
    public void MotorcycleImpl_ShouldImplementVehicleInterface() {
        MotorcycleImpl motorcycle = new MotorcycleImpl("make", "model", 100, "category");
        Assertions.assertTrue(motorcycle instanceof Vehicle);
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {MAKE_NAME_LEN_MIN - 1, MAKE_NAME_LEN_MAX + 1})
    public void should_throwException_when_makeNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new MotorcycleImpl(
                        initializeStringWithSize(testLength),
                        TestData.VehicleBase.VALID_MODEL,
                        TestData.VehicleBase.VALID_PRICE,
                        TestData.Motorcycle.VALID_CATEGORY));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {MODEL_NAME_LEN_MIN - 1, MODEL_NAME_LEN_MAX + 1})
    public void should_throwException_when_modelNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new MotorcycleImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        initializeStringWithSize(testLength),
                        TestData.VehicleBase.VALID_PRICE,
                        TestData.Motorcycle.VALID_CATEGORY));
    }

    @ParameterizedTest(name = "with price: {0}")
    @ValueSource(ints = {-1, 1000001})
    public void should_throwException_when_priceIsInvalid(int testPrice) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new MotorcycleImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        TestData.VehicleBase.VALID_MODEL,
                        testPrice,
                        TestData.Motorcycle.VALID_CATEGORY));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {CATEGORY_LEN_MIN - 1, CATEGORY_LEN_MAX + 1})
    public void should_throwException_when_categoryLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new MotorcycleImpl(
                        TestData.VehicleBase.VALID_MAKE,
                        TestData.VehicleBase.VALID_MODEL,
                        TestData.VehicleBase.VALID_PRICE,
                        initializeStringWithSize(testLength)));
    }
}
