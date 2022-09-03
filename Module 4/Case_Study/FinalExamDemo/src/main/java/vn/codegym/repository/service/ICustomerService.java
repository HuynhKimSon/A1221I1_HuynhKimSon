package vn.codegym.repository.service;

import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.response.ResultCustomerRes;
import vn.codegym.model.customer.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    ResultCustomerRes save(CustomerDto customerDto);

    void delete(Long id);
}
