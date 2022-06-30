package vn.codegym.Repository;

import vn.codegym.Model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRep {
    List<Customer> findAll() throws SQLException;

    boolean delete(String IDs) throws SQLException;

    void save(Customer customer) throws SQLException;

    List<Customer> findBy(String key, String value) throws SQLException;
}
