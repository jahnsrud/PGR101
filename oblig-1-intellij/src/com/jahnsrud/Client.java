package com.jahnsrud;

import java.util.List;

public class Client {

    public Client() {

        mainMethod();

    }

    public void mainMethod() {

        System.out.println("Hello, World!");

        MeterArchive meterArchive = new MeterArchive();

        // Legg til placeholder-innhold
        addPlaceholderContent(meterArchive);



        List<Meter>testList = meterArchive.getAllMeters();

        System.out.println("Viser alle instrumenter \n");

        for(Meter meter : testList) {
            System.out.println("---------\n");
            System.out.println(meter);
            System.out.println("\n---------");
        }



    }

    public void addPlaceholderContent(MeterArchive meterArchive) {

        Clock testClock = new Clock("ABC000", "A123", true, 0.1);
        meterArchive.addMeter(testClock);

        Thermometer testThermometer = new Thermometer("CBA111", "123A", true, 0, 100);
        meterArchive.addMeter(testThermometer);

        Weight testWeight = new Weight("ÆØÅ222", "000L", true, 0, 1000);
        meterArchive.addMeter(testWeight);

    }

}
