package FuramaResort.models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String nameService, double usableArea, double cost, int maximumPeople, String rentalType, String roomStandard, double poolArea, int numberOfFloors) {
        super(nameService, usableArea, cost, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
