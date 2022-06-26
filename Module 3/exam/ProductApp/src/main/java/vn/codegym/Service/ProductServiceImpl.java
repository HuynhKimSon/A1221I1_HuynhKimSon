package vn.codegym.Service;

import vn.codegym.Model.Product;
import vn.codegym.Reponsitory.IProductRepository;
import vn.codegym.Reponsitory.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    private IProductRepository userRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public void delete(String IDs) throws SQLException {
        userRepository.delete(IDs);
    }

    @Override
    public void save(Product product) throws SQLException {
        userRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
