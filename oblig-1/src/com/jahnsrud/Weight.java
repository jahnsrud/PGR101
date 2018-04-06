package library;

import java.util.Objects;

public class Weight extends Meter {

    private double minWeight;
    private double maxWeight;
    private static final String unit = "Gram";

    public Weight() {
        super();
        setMinWeight(0);
        setMaxWeight(1000);

    }

    public Weight(String id, String locationCode, boolean isFunctional, double minWeight, double maxWeight) {
        super(id, locationCode, isFunctional);
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

        return "- Vekt" + "\n" + "Vekt - minimum: " + getMinWeight() + "\n" + "Vekt - maksimum: " + getMaxWeight() + "\n" + super.toString();

    }

    /*
    @Override
    public boolean equals(Object o) {


    }
    */


}
