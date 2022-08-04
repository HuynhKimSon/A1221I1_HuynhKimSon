package vn.codegym.service;

import vn.codegym.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);
}
