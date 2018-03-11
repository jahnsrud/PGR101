package com.jahnsrud;

import java.util.Objects;

public abstract class Meter {

    private String id;
    private String locationCode;
    private boolean isFunctional;

    public Meter() {

        /**
         * Todo: improve
         */

        this("DEFAULT", "ABC", true);

    }

    public Meter(String id, String locationCode, boolean isFunctional) {
        this.id = id;
        setLocationCode(locationCode);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public final void setLocationCode(String locationCode) {
        this.locationCode = locationCode.trim().toUpperCase();
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
