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
     * @param meter reference to a meter to add
     */
    public void addMeter(Meter meter) {

        meters.add(meter);

    }

    /**
     * Get a meter using id
     * @param id
     * @return a meter if found, null if not
     */

    public Meter getMeter(String id) {

        for(Meter meter : meters) {

            if (meter.getId().equals(id)) {

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
     * @param id
     * @return
     */
    public boolean delete(String id) {

        Meter meter = getMeter(id);
        if (meter == null) {
            return false;
        }

        meters.remove(meter);

        return true;
    }

    public boolean changeLocation(String id, String newLocation) {

        Meter meter = getMeter(id);

        if (meter == null) {
            return false;
        }

        meter.setLocationCode(newLocation);

        return true;

    }

    public boolean setMeterNonFunctional(String id) {

        Meter meter = getMeter(id);

        if (meter == null) {
            return false;
        }

        meter.setFunctional(false);

        return true;
    }

    /**
     * Prints all meters to our terminal
     */

    public void printAllMeters() {

        System.out.println("\n*********\n");

        System.out.println("Viser alle instrumenter");

        System.out.println("\n---------");

        for(Meter meter : meters) {
            System.out.println(meter);
            System.out.println("---------");
        }



    }

}
