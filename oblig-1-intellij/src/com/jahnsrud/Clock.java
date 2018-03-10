package com.jahnsrud;

public class Clock extends Meter {

    private double smallestTimeInterval; // annet navn

    public Clock(String regNr, String locationCode, boolean isFunctional, double smallestTimeInterval) {
        super(regNr, locationCode, isFunctional);
        this.smallestTimeInterval = smallestTimeInterval;
    }

    public Clock(String regNr, String locationCode, boolean isFunctional) {
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
