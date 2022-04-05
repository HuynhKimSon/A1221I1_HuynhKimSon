package FuramaResort.models.facility;

public class House extends Facility{
    private String roomStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String nameService, double usableArea, double cost, int maximumPeople, String rentalType, String roomStandard, int numberOfFloors) {
        super(nameService, usableArea, cost, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
