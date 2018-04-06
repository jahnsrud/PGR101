package library;

public class Thermometer extends Meter {

    private double minTemp;
    private double maxTemp;
    private static final String unit = "Celsius";

    public Thermometer() {
        super();
        setMinTemp(0);
        setMaxTemp(100);

    }

    public Thermometer(String id, String locationCode, boolean isFunctional, double minTemp, double maxTemp) {
        super(id, locationCode, isFunctional);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "- Termometer" + "\n" + "Temperatur - minimum: " + getMinTemp() + "\n" + "Temperatur - maksimum: " + getMaxTemp() + "\n" + super.toString();
    }

    /*
    @Override
    public boolean equals(Object o) {}

*/

}