package FinalExam.model;

public abstract class Product {
    private int id;
    private int code;
    private String name;
    private double price;
    private int quality;
    private String manufacturer;

    public Product() {
    }

    public Product(int id, int code, String name, double price, int quality, String manufacturer) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quality = quality;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return id + ","
                + code + ","
                + name + ","
                + price + ","
                + quality + ","
                + manufacturer + ",";
    }
}
