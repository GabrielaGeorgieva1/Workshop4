package com.telerikacademy.oop.dealership;

import com.telerikacademy.oop.dealership.core.VehicleDealershipEngineImpl;

public class Startup {

    public static void main(String[] args) {
        VehicleDealershipEngineImpl engine = new VehicleDealershipEngineImpl();
        engine.start();
    }

}
