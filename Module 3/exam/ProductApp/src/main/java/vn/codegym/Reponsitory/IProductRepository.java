package vn.codegym.Reponsitory;

import vn.codegym.Model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll() throws SQLException;

    boolean delete(String IDs) throws SQLException;

    void save(Product product) throws SQLException;

    List<Product> findBy(String key, String value) throws SQLException;

}
