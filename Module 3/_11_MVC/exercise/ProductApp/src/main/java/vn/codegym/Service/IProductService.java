package vn.codegym.Service;

import vn.codegym.Model.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> findAll();

    void delete(int id);

    void edit(Product product);

    List<Product> findByName(String Name);
}
