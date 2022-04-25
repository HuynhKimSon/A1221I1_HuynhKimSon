package FuramaResort.services;

import FuramaResort.models.customer.Customer;

import java.util.List;

public interface ICustomerService extends BaseService<Customer> {
    @Override
    List<Customer> getAll();

    @Override
    void save(Customer customer, String type);
}
