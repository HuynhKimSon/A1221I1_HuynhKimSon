package FuramaResort.repository;

import FuramaResort.models.customer.Customer;

import java.util.List;

public interface ICustomerRepository extends BaseRepository<Customer> {

    @Override
    List<Customer> getAll();

    @Override
    void save(Customer customer, String type);
}
