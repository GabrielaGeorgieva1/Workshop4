package com.telerikacademy.oop.dealership.commands;

import com.telerikacademy.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import java.util.List;

public class ShowUsersCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;
    public VehicleDealershipRepository vehicleDealershipRepository;

    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository) {
        super(vehicleDealershipRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return showUser();
    }

    private String showUser() {
        return vehicleDealershipRepository.getUsers().toString();
    }

    @Override
    protected boolean requiresLogin() {
        return false;
    }
}
