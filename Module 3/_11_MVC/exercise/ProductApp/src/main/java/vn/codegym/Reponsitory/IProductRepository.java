package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.util.List;

public interface IRepositoryProduct {
    List<Product> findAll();

    void delete(int id);

    void edit(Product product);

    List<Product> findByName(String Name);
}
