package VehicleManagement.models;

public class MotorCycle extends Vehicle {
    private int wattage;

    public MotorCycle() {
    }

    public MotorCycle(String numberVehicle, String manufacturer, int yearManufacturer, String owner, int wattage) {
        super(numberVehicle, manufacturer, yearManufacturer, owner);
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
