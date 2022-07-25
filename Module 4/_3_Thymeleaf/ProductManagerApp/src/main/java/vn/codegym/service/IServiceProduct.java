package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface IServiceProduct {

    List<Product> findAll();

    void save(Product product);
}
