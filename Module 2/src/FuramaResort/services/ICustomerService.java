package FuramaResort.services;

import FuramaResort.models.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> display();

    void add(Customer customer, String type);
}
