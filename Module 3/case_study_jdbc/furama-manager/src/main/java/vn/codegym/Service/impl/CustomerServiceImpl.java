package vn.codegym.Service.impl;

import vn.codegym.Model.Customer;
import vn.codegym.Repository.ICustomerRep;
import vn.codegym.Repository.impl.CustomerRepImpl;
import vn.codegym.Service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRep customerRep = new CustomerRepImpl();

    @Override
    public List<Customer> findAll() throws SQLException {
        return customerRep.findAll();
    }

    @Override
    public void delete(String IDs) throws SQLException {
        customerRep.delete(IDs);
    }

    @Override
    public void save(Customer customer) throws SQLException {
        customerRep.save(customer);
    }

    @Override
    public List<Customer> findBy(String key, String value) throws SQLException {
        return customerRep.findBy(key, value);
    }
}
