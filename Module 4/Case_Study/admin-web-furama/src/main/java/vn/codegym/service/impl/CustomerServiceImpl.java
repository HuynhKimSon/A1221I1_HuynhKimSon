package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.customer.Customer;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.service.ICustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }
}
