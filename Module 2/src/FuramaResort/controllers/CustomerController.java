package FuramaResort.controllers;

import FuramaResort.models.customer.Customer;
import FuramaResort.services.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerServiceImpl iCustomerServiceImpl = new CustomerServiceImpl();

    public List<Customer> display() {
        return iCustomerServiceImpl.getAll();
    }

    public void save(Customer customer, String type) {
        iCustomerServiceImpl.save(customer, type);
    }
}
