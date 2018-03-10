package com.jahnsrud;

import java.util.ArrayList;
import java.util.List;

public class MeterArchive {

    private List<Meter> meters;

    public MeterArchive() {

        meters = new ArrayList<>();



    }

    public void addMeter(Meter meter) {

        meters.add(meter);

    }

    public void getMeter(String regNr) {

    }

    public List getAllMeters() {
        return meters;
    }

    public boolean deleteMeter(String regNr) {


        return true;
    }

    public boolean changeLocation(String regNr, String newLocation) {

        return true;

    }

    public boolean setMeterNonFunctional(String regNr) {

        
        return true;
    }

}
