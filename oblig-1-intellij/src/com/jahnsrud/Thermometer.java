package com.jahnsrud;

public class Thermometer extends Meter {

    private double minTemp;
    private double maxTemp;

    public Thermometer() {
        /**
         * Todo: improve
         */

        this("TEST", "TEST", true, 0, 100);

    }

    public Thermometer(String regNr, String locationCode, boolean isFunctional, double minTemp, double maxTemp) {
        super(regNr, locationCode, isFunctional);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public Thermometer(String regNr, String locationCode, boolean isFunctional) {
        super(regNr, locationCode, isFunctional);
    }

    public String toString() {
        return "";
    }

/*
    @Override
    public boolean equals(Object o) {}

*/

}