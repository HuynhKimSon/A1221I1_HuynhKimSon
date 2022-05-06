package VehicleManagement.models;

public class Car {
    private int numberOfSeats;
    private String typeVehicle;

    public Car() {
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    @Override
    public String toString() {
        return super.toString()
                + numberOfSeats + ","
                + typeVehicle;
    }
}
