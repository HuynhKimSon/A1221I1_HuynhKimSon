package FuramaResort.libs;

import FuramaResort.models.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> display();

    void save(boolean isAdd, int indexEdit, Customer customer, String type);
}
