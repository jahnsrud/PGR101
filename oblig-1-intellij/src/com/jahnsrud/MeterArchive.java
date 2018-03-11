package com.jahnsrud;

import java.util.List;
import java.util.ArrayList;

public class MeterArchive {

    private List<Meter> meters;

    public MeterArchive() {

        meters = new ArrayList<>();

    }

    /**
     * Add a meter to our list
     * Avoids duplication if there is already a meter with the same id
     *
     * @param meter reference to a meter
     */
    public void addMeter(Meter meter) {

        Meter meterToCompare = getMeter(meter.getId());

        if (meterToCompare == null) {

            meters.add(meter);

        } else {
            System.out.println("Hopper over å legge til duplikat id: " + meter.getId());
        }

    }

    /**
     * Get a meter using an id
     *
     * @param id
     * @return the first meter if found, null if not
     */

    public Meter getMeter(String id) {

        for (Meter meter : meters) {

            if (meter.getId().equals(id)) {

                return meter;

            }

        }

        return null;

    }

    /**
     * Get our list
     *
     * @return the List with all meters
     */

    private List getAllMeters() {
        return meters;
    }

    /**
     * Delete a meter
     *
     * @param id for the meter to delete
     * @return true if deletion was successful
     */
    public boolean delete(String id) {

        Meter meter = getMeter(id);
        if (meter == null) {
            return false;
        }

        meters.remove(meter);

        return true;
    }

    /**
     * Change location
     *
     * @param id          for the meter to update
     * @param newLocation the meter's new location
     * @return true if update was successful
     */

    public boolean changeLocation(String id, String newLocation) {

        Meter meter = getMeter(id);

        if (meter == null) {
            return false;
        }

        meter.setLocationCode(newLocation);

        return true;

    }

    /**
     * Indicate that the meter is non-functional
     *
     * @param id for the meter to update
     * @return true if update was successful
     */

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

        for (Meter meter : meters) {
            System.out.println(meter);
            System.out.println("---------");
        }


    }

}
