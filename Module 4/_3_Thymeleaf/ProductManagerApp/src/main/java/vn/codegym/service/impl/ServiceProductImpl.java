package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.IRepositoryProduct;
import vn.codegym.service.IServiceProduct;

import java.util.List;

@Service
public class ServiceProductImpl implements IServiceProduct {

    @Autowired
    private IRepositoryProduct repositoryProduct;

    @Override
    public List<Product> findAll() {
        return repositoryProduct.findAll();
    }

    @Override
    public void save(Product product) {
        repositoryProduct.save(product);
    }
}
