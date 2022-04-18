package _12_java_collection_framework.exercice.e1;

import java.util.Map;
import java.util.TreeMap;

public class ProductManager {
    private String nameProduct;
    private double price;
    private static final Map<Integer, ProductManager> mapItem = new TreeMap<>();

    public ProductManager() {
    }

    public ProductManager(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public boolean push(int id, ProductManager item) {
        if (mapItem.containsKey(id)) {
            return false;
        }
        mapItem.put(id, item);
        return true;
    }

    public boolean edit(int id, ProductManager item) {
        if (mapItem.containsKey(id)) {
            mapItem.put(id, item);
            return true;
        }
        return false;
    }

    public boolean remove(int id) {
        if (mapItem.containsKey(id)) {
            mapItem.remove(id);
            return true;
        }
        return false;
    }

    public ProductManager searchProduct(int id) {
        return mapItem.get(id);
    }

    public Map<Integer, ProductManager> getMapItem() {
        return mapItem;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }
}
