package ProductManagement.models;

public abstract class Product {
    private int id;
    private String productName;
    private String price;
    private String producer;

    public Product() {
    }

    public Product(int id, String productName, String price, String producer) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return id + ","
                + productName + ","
                + price + ","
                + producer + ",";
    }
}
