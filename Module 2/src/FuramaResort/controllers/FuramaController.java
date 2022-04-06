package FuramaResort.controllers;

import FuramaResort.models.customer.Customer;
import FuramaResort.services.impl.CustomerServiceImpl;

import java.util.List;

public class FuramaController {
    private static CustomerServiceImpl iCustomerServiceImpl = new CustomerServiceImpl();

    public List<Customer> display() {
        return iCustomerServiceImpl.display();
    }
}
