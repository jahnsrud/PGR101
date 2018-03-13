package library;

public class Clock extends Meter {

    private double minTimeInterval;
    private static final String unit = "Sekunder";

    public Clock() {
        super();
        setMinTimeInterval(1.0);

    }

    public Clock(String id, String locationCode, boolean isFunctional, double minTimeInterval) {
        super(id, locationCode, isFunctional);
        this.minTimeInterval = minTimeInterval;
    }

    public double getMinTimeInterval() {
        return minTimeInterval;
    }

    public void setMinTimeInterval(double minTimeInterval) {
        this.minTimeInterval = minTimeInterval;
    }

    @Override
    public String toString() {

        return "- Klokke" + "\n" + "Minste tidsintervall: " + getMinTimeInterval() + "\n" + super.toString();

    }

    /*
    @Override
    public boolean equals(Object o) {}

*/

}
