package VehicleManagement.models;

public class MotorCycle {
    private int wattage;

    public MotorCycle() {
    }

    public MotorCycle(int wattage) {
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString()
                + wattage;
    }
}
