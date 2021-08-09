package com.telerikacademy.oop.dealership.core.contracts;

import com.telerikacademy.oop.dealership.commands.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString, VehicleDealershipRepository vehicleDealershipRepository);

}
