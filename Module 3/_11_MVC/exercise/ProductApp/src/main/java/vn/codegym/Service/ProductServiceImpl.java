package vn.codegym.Service;

import vn.codegym.Model.Product;
import vn.codegym.Reponsitory.IProductRepository;
import vn.codegym.Reponsitory.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String Name) {
        return null;
    }
}
