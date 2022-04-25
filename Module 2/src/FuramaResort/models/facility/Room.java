package FuramaResort.models.facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String idService, String nameService, double usableArea, double cost, int maximumPeople, String rentalType, String freeService) {
        super(idService, nameService, usableArea, cost, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString()
                + freeService;
    }
}
