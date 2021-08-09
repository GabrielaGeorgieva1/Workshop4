package com.telerikacademy.oop.dealership.utils;

import com.telerikacademy.oop.dealership.models.contracts.*;

import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

public class Mapper {

    //  public static List<String> mapTruckToParamsList(Truck t) {
    //      List<String> result = mapVehicleToParamsList(t);
    //      result.add(valueOf(t.getWeightCapacity()));
    //      return result;
    //  }

    //  public static List<String> mapCarToParamsList(Car c) {
    //      List<String> result = mapVehicleToParamsList(c);
    //      result.add(valueOf(c.getSeats()));
    //      return result;
    //  }

    //  public static List<String> mapMotorcycleToParamsList(Motorcycle m) {
    //      List<String> result = mapVehicleToParamsList(m);
    //      result.add(m.getCategory());
    //      return result;
    //  }

    //  private static List<String> mapVehicleToParamsList(Vehicle v) {
    //      return new LinkedList<>(asList(v.getType().toString(), v.getMake(), v.getModel(), valueOf(v.getPrice())));
    //  }

    //  public static List<String> mapUserToParamsList(User u) {
    //      return asList(u.getUsername(), u.getFirstName(), u.getLastName(), u.getPassword());
    //  }

    //  public static List<String> mapCommentToParamsList(Comment c) {
    //      return asList(format("%s", c.getContent()), c.getAuthor(), valueOf(1));
    //  }

}
