package VehicleManagement.models;

public abstract class Vehicle {
    private String numberVehicle;
    private String manufacturer;
    private int yearManufacturer;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String numberVehicle, String manufacturer, int yearManufacturer, String owner) {
        this.numberVehicle = numberVehicle;
        this.manufacturer = manufacturer;
        this.yearManufacturer = yearManufacturer;
        this.owner = owner;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearManufacturer() {
        return yearManufacturer;
    }

    public void setYearManufacturer(int yearManufacturer) {
        this.yearManufacturer = yearManufacturer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return numberVehicle + ","
                + manufacturer + ","
                + yearManufacturer + ","
                + owner + ",";
    }
}
