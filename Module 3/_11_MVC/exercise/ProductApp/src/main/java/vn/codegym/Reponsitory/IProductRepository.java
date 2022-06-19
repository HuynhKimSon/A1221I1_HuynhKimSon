package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void delete(int id);

    void save(Product product);

    List<Product> findByName(String Name);
}
