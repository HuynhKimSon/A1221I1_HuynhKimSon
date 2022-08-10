package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findPage(Pageable pageable);

    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void delete(Long id);
}
