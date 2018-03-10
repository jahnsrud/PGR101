package com.jahnsrud;

import java.util.Objects;

public class Weight extends Meter {

    private double minWeight;
    private double maxWeight;

    public Weight() {
        /**
         * Todo: improve
         */

        this("TEST", "TEST", true, 0, 1000);
    }

    public Weight(String regNr, String locationCode, boolean isFunctional, double minWeight, double maxWeight) {
        super(regNr, locationCode, isFunctional);
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    // ????
    public Weight(String regNr, String locationCode, boolean isFunctional) {
        super(regNr, locationCode, isFunctional);
    }

    /*
    @Override
    public boolean equals(Object o) {


    }
    */


}
