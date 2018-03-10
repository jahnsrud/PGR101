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

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "Temperatur - minimum: " + getMinTemp() + "\n" + "Temperatur - maksimum: " + getMaxTemp() + "\n" + super.toString();
    }

    /*
    @Override
    public boolean equals(Object o) {}

*/

}