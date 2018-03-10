package com.jahnsrud;

public class Client {

    public Client() {

        mainMethod();

    }

    public void mainMethod() {

        System.out.println("Arbeidskrav 1");
        System.out.println("Hello, World!");

        MeterArchive meterArchive = new MeterArchive();

        // Legg til placeholder-innhold
        addPlaceholderContent(meterArchive);

        // Print ut alle
        meterArchive.printAllMeters();

        System.out.println("Takk for meg (╯°□°）╯︵ ");



    }

    public void addPlaceholderContent(MeterArchive meterArchive) {

        Clock myClock = new Clock("ABC000", "A123", true, 0.1);
        meterArchive.addMeter(myClock);

        Thermometer myThermometer = new Thermometer("CBA111", "123A", true, 0, 100);
        meterArchive.addMeter(myThermometer);

        Weight myWeight = new Weight("ÆØÅ222", "000L", true, 0, 1000);
        meterArchive.addMeter(myWeight);

    }

}
