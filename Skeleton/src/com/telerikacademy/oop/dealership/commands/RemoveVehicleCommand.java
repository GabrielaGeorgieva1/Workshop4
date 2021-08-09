package com.telerikacademy.oop.dealership.commands;


import com.telerikacademy.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.telerikacademy.oop.dealership.models.contracts.User;
import com.telerikacademy.oop.dealership.models.contracts.Vehicle;
import com.telerikacademy.oop.dealership.utils.ParsingHelpers;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import java.util.List;


public class RemoveVehicleCommand extends BaseCommand {

    private final static String VEHICLE_REMOVED_SUCCESSFULLY = "%s removed vehicle successfully!";
    private final static String INVALID_VEHICLE_INDEX = "Invalid vehicle index. Expected a number.";
    private final static String VEHICLE_INDEX_OUT_OF_BOUNDS = "There is no vehicle on this index.";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public RemoveVehicleCommand(VehicleDealershipRepository vehicleDealershipRepository) {
        super(vehicleDealershipRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int vehicleIndex = ParsingHelpers.tryParseInt(parameters.get(0), INVALID_VEHICLE_INDEX) - 1;
        return removeVehicle(vehicleIndex);
    }

    private String removeVehicle(int vehicleIndex) {
        User loggedUser = getVehicleDealershipRepository().getLoggedInUser();
        ValidationHelpers.validateIntRange(vehicleIndex, 0, loggedUser.getVehicles().size(), VEHICLE_INDEX_OUT_OF_BOUNDS);

        Vehicle vehicle = loggedUser.getVehicles().get(vehicleIndex);

        loggedUser.removeVehicle(vehicle);

        return String.format(VEHICLE_REMOVED_SUCCESSFULLY, loggedUser.getUsername());
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }
}
