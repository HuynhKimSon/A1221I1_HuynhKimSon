package vn.codegym.Service;

import vn.codegym.Model.Product;
import vn.codegym.Reponsitory.IProductRepository;
import vn.codegym.Reponsitory.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() throws SQLException {
        return productRepository.findAll();
    }

    @Override
    public void delete(String IDs) throws SQLException {
        productRepository.delete(IDs);
    }

    @Override
    public void save(Product product) throws SQLException {
        productRepository.save(product);
    }

    @Override
    public List<Product> findBy(String key, String value) throws SQLException {
        return productRepository.findBy(key, value);
    }

    @Override
    public HashMap<Integer, String> findAllCategory() {
        return productRepository.findAllCategory();
    }

}
