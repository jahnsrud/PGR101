package com.jahnsrud;

import java.util.List;

public class Client {

    public Client() {

        mainMethod();

    }

    public void mainMethod() {

        System.out.println("Hello, World. Fra Client.");

        MeterArchive meterArchive = new MeterArchive();

        Meter testClock = new Clock("ABC000", "A123", true, 0.1);

        meterArchive.addMeter(testClock);

        List<Meter>testList = meterArchive.getAllMeters();

        for(Meter meter : testList) {
            System.out.println(meter);
        }

    }

}
