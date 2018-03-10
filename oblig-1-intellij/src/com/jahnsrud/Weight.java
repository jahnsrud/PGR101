package com.jahnsrud;

public class Weight extends Meter {

    private double minWeight;
    private double maxWeight;

    public Weight(String regNr, String locationCode, boolean isFunctional, double minWeight, double maxWeight) {
        super(regNr, locationCode, isFunctional);
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    // ????
    public Weight(String regNr, String locationCode, boolean isFunctional) {
        super(regNr, locationCode, isFunctional);
    }

}
