package VehicleManagement.models;

public class Truck extends Vehicle{
    private int weight;

    public Truck() {
    }

    public Truck(String numberVehicle, String manufacturer, int yearManufacturer, String owner, int weight) {
        super(numberVehicle, manufacturer, yearManufacturer, owner);
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString()
                + weight;
    }
}
