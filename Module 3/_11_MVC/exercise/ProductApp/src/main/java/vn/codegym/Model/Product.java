package vn.codegym.Model;

public class Product {
    private int id;
    private String nameProduct;
    private double priceProduct;
    private String descriptionProduct;
    private String manufacturer;
    private String imgProduct;

    public Product() {
    }

    public Product(int id, String nameProduct, double priceProduct, String descriptionProduct, String manufacturer, String imgProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.manufacturer = manufacturer;
        this.imgProduct = imgProduct;
    }

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }
}
