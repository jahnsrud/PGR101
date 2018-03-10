package com.jahnsrud;

import java.util.ArrayList;
import java.util.List;

public class MeterArchive {

    private List<Meter> meters;

    public MeterArchive() {

        meters = new ArrayList<>();


    }

    /**
     * Add a meter to our list
     * @param a reference to a meter to add
     */
    public void addMeter(Meter meter) {

        meters.add(meter);

    }

    /**
     * Get a meter using regNr
     * @param regNr
     * @return a meter if found, null if not
     */

    public Meter getMeter(String regNr) {

        for(Meter meter : meters) {

            if (meter.getRegNr().equals(regNr)) {

                return meter;

            }

        }

        return null;

    }

    public List getAllMeters() {
        return meters;
    }

    /**
     * Delete
     * @param regNr
     * @return
     */
    public boolean delete(String regNr) {

        Meter meter = getMeter(regNr);
        if (meter == null) {
            return false;
        }

        meters.remove(meter);

        return true;
    }

    public boolean changeLocation(String regNr, String newLocation) {

        return true;

    }

    public boolean setMeterNonFunctional(String regNr) {

        Meter meter = getMeter(regNr);

        if (meter == null) {
            return false;
        }

        meter.setFunctional(false);

        return true;
    }

}
