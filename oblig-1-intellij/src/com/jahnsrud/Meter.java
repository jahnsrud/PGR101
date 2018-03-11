package com.jahnsrud;

import java.util.Objects;

public abstract class Meter {

    private String id;
    private String locationCode;
    private boolean isFunctional;

    private static final String DEFAULT_ID = "000";
    private static final String DEFAULT_LOCATION_CODE = "ABC";
    private static final boolean DEFAULT_FUNCTIONAL = true;


    public Meter() {

        this(DEFAULT_ID, DEFAULT_LOCATION_CODE, DEFAULT_FUNCTIONAL);

    }

    public Meter(String id, String locationCode, boolean isFunctional) {
        this.id = id;
        setLocationCode(locationCode);
        this.isFunctional = isFunctional;
    }

    public String getLocationCode() {
        return locationCode;
    }

    /**
     * Set new location
     * Removes whitespace and forces uppercase characters
     *
     * @param locationCode
     */

    public final void setLocationCode(String locationCode) {
        this.locationCode = locationCode.trim().toUpperCase();
    }

    /**
     * A helping hand for creating location codes
     *
     * @param room  our room number
     * @param shelf the shelf number
     * @return a string that fits our naming format. For example R101H9
     */

    public String createLocationCode(int room, int shelf) {

        return "R" + room + "H" + shelf;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }

    @Override
    public String toString() {
        return "\n" + "Registreringsnummer: " + id + "\n" +
                "Plasseringskode: " + locationCode + "\n" +
                "Fungerer instrumentet? " + isFunctional;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meter meter = (Meter) o;
        return isFunctional == meter.isFunctional &&
                Objects.equals(id, meter.id) &&
                Objects.equals(locationCode, meter.locationCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, locationCode, isFunctional);
    }


}
