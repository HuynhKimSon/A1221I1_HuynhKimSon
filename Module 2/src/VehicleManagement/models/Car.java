package VehicleManagement.models;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String typeVehicle;

    public Car() {
    }

    public Car(String numberVehicle, String manufacturer, int yearManufacturer, String owner, int numberOfSeats, String typeVehicle) {
        super(numberVehicle, manufacturer, yearManufacturer, owner);
        this.numberOfSeats = numberOfSeats;
        this.typeVehicle = typeVehicle;
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
