package com.jahnsrud;

public abstract class Meter {

    private String regNr;
    private String locationCode;
    private boolean isFunctional;

    public Meter() {

        /**
         * Todo: improve
         */

        this("DEFAULT", "ABC", true);

    }

    public Meter(String regNr, String locationCode, boolean isFunctional) {
        this.regNr = regNr;
        this.locationCode = locationCode;
        this.isFunctional = isFunctional;
    }

    /**
     * A helping hand for creating location codes
     * @param room
     * @param shelf
     * @return
     */

    public String createLocationCode(int room, int shelf) {

        return "R" + room + "H" + shelf;

    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }

    @Override
    public String toString() {
        return "regNr = '" + regNr + '\'' +
                ", locationCode = '" + locationCode + '\'' +
                ", isFunctional = " + isFunctional +
                '}';
    }

    /*
    Equals.
     */
}
