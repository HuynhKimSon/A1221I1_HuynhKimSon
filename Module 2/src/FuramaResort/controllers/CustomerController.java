package FuramaResort.controllers;

import FuramaResort.libs.impl.CustomerRepositoryImpl;
import FuramaResort.models.customer.Customer;
import FuramaResort.services.impl.CustomerServiceImpl;
import FuramaResort.services.impl.EmployeeServiceImpl;

import java.util.List;

public class CustomerController {
    private static CustomerServiceImpl iCustomerServiceImpl = new CustomerServiceImpl();

    public List<Customer> display() {
        return iCustomerServiceImpl.display();
    }

    public void add(Customer customer, String type) {
        iCustomerServiceImpl.add(customer, type);
    }
}
