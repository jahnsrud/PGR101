package com.jahnsrud;

public class Clock extends Meter {

    private double smallestTimeInterval; // annet navn

    public Clock() {
        /**
         * Todo: improve
         */
        this("TEST", "TEST", true, 1.0);
    }

    public Clock(String regNr, String locationCode, boolean isFunctional, double smallestTimeInterval) {
        super(regNr, locationCode, isFunctional);
        this.smallestTimeInterval = smallestTimeInterval;
    }

    public Clock(String regNr, String locationCode, boolean isFunctional) {
        super(regNr, locationCode, isFunctional);
    }

    public double getSmallestTimeInterval() {
        return smallestTimeInterval;
    }

    public void setSmallestTimeInterval(double smallestTimeInterval) {
        this.smallestTimeInterval = smallestTimeInterval;
    }

    @Override
    public String toString() {

        return "Kommer snart";

    }

    /*
    @Override
    public boolean equals(Object o) {}

*/

}
