package FuramaResort.models.facility;

public class Facility {
    private String nameService;
    private double usableArea;
    private double cost;
    private int maximumPeople;
    private String rentalType;

    public Facility(String nameService, double usableArea, double cost, int maximumPeople, String rentalType) {
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.cost = cost;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public Facility() {
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }


}
