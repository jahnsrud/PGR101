package com.jahnsrud;

public class Meter {

    private String regNr;
    private String locationCode;
    private boolean isFunctional;

    public Meter(String regNr, String locationCode, boolean isFunctional) {
        this.regNr = regNr;
        this.locationCode = locationCode;
        this.isFunctional = isFunctional;
    }

    private String createPlacementCode(int room, int shelf) {

        return "R" + room + "H" + shelf;

    }

    @Override
    public String toString() {
        return "Meter{" +
                "regNr='" + regNr + '\'' +
                ", locationCode='" + locationCode + '\'' +
                ", isFunctional=" + isFunctional +
                '}';
    }

    /*
    Equals.
     */
}
