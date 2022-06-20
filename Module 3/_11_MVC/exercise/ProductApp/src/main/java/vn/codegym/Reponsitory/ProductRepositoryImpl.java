package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Bánh 1", 15000, "Bánh 1", "USA", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(2, "Bánh 2", 25000, "Bánh 1", "VN", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(3, "Bánh 3", 35000, "Bánh 1", "VN", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(4, "Bánh 4", 45000, "Bánh 1", "VN", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(5, "Bánh 5", 55000, "Bánh 1", "USA", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(6, "Bánh 6", 65000, "Bánh 1", "UK", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(7, "Bánh 7", 75000, "Bánh 1", "USA", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(8, "Bánh 8", 85000, "Bánh 1", "UK", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(9, "Bánh 9", 75000, "Bánh 1", "USA", "/mau-banh-kem-socola-dep-2.jpg"));
        products.add(new Product(10, "Bánh 10", 85000, "Bánh 1", "UK", "/mau-banh-kem-socola-dep-2.jpg"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void delete(String IDs) {
        String[] list = IDs.split(",");
        Arrays.stream(list).forEach(e -> products.removeIf(f -> f.getId() == Integer.parseInt(e)));
    }

    @Override
    public void save(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                System.err.println(product.getNameProduct());
                products.set(i, product);
                return;
            }
        }
        products.add(product);
    }

    @Override
    public List<Product> findByName(String Name) {
        return null;
    }
}
