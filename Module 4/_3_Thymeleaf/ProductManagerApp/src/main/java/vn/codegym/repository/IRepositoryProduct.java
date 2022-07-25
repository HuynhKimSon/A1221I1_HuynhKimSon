package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface IRepositoryProduct {

    List<Product> findAll();

    void save(Product product);
}
