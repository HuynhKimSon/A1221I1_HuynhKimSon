package ProductManagement.services;

import ProductManagement.models.Product;

import java.util.List;

public interface IProductService extends BaseService<Product> {

    @Override
    List<Product> getAll();

    @Override
    void Save(Product product);

    @Override
    boolean remove(String id);

    @Override
    List<Product> search(String id);
}
