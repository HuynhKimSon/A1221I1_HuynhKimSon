package vn.codegym.Service;


import vn.codegym.Model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> findAll() throws SQLException;

    void delete(String IDs) throws SQLException;

    void save(Product product) throws SQLException;

    List<Product> findByName(String name);
}
