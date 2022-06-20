package vn.codegym.Service;

import vn.codegym.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void delete(String IDs);

    void save(Product product);

    List<Product> findByName(String Name);
}
