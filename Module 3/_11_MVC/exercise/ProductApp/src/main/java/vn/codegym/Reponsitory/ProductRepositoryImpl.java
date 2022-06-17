package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProductImpl implements IRepositoryProduct {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Bánh 1", 15000, "Bánh 1", "USA", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(2, "Bánh 2", 25000, "Bánh 1", "VN", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(3, "Bánh 3", 35000, "Bánh 1", "VN", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(4, "Bánh 4", 45000, "Bánh 1", "VN", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(5, "Bánh 5", 55000, "Bánh 1", "USA", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(6, "Bánh 6", 65000, "Bánh 1", "UK", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(7, "Bánh 7", 75000, "Bánh 1", "USA", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(8, "Bánh 8", 85000, "Bánh 1", "UK", "https://cdn.pastaxi-manager.onepas.vn/content/uploads/articles/mau-banh-kem-socola-dep-2.jpg"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public List<Product> findByName(String Name) {
        return null;
    }
}
