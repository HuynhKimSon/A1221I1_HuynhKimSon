package vn.codegym.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.repository.ICustomerTypeRepository;
import vn.codegym.repository.service.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Long id) {
        return customerTypeRepository.findById(id).orElse(new CustomerType());
    }

}
