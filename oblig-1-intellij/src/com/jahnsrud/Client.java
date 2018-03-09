package com.jahnsrud;

public class Client {

    public Client() {

        mainMethod();

    }

    public void mainMethod() {

        System.out.println("Hello, World. Fra Client.");

        MeterArchive meterArchive = new MeterArchive();

        Meter testClock = new Clock();

        meterArchive.addMeter(testClock);



    }

}
