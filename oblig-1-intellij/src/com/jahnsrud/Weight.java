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

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {

        return "Vekt - minimum: " + getMinWeight() + "\n" + "Vekt - maksimum: " + getMaxWeight() + "\n" + super.toString();

    }

    /*
    @Override
    public boolean equals(Object o) {


    }
    */


}
