package vn.codegym.repository.service;

import vn.codegym.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Long id);
}
