package vn.codegym.Service;

import vn.codegym.Model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {

    List<Customer> findAll() throws SQLException;

    void delete(String IDs) throws SQLException;

    void save(Customer customer) throws SQLException;

    List<Customer> findBy(String key ,String value) throws SQLException;
}
