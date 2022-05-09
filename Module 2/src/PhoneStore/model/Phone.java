package PhoneStore.model;

public abstract class Phone {
    private String type;
    private int id;
    private String name;
    private double price;
    private String manufacturer;

    public Phone() {
    }

    public Phone(String type, int id, String name, double price, String manufacturer) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", type, id, name, price, manufacturer);
    }
}
