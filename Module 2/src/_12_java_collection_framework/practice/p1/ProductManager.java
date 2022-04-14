package _12_java_collection_framework.practice.p1;

import java.util.TreeMap;

public class ProductManager {
    private int id;
    private String nameProduct;
    private double price;
    private static final TreeMap<Integer, ProductManager> mapItem = new TreeMap<>();

    public ProductManager() {
    }

    public ProductManager(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public void push(int id, ProductManager item) {
        mapItem.put(id, item);
    }

    public TreeMap<Integer, ProductManager> getMapItem() {
        return mapItem;
    }

    public String getNameProduct() {
        return nameProduct;
    }
    
    public double getPrice() {
        return price;
    }
}
