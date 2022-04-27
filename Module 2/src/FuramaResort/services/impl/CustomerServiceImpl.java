package FuramaResort.services.impl;

import FuramaResort.repository.ICustomerRepository;
import FuramaResort.repository.impl.CustomerRepositoryImpl;
import FuramaResort.models.customer.Customer;
import FuramaResort.services.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository iSCustomerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> getAll() {
        return iSCustomerRepository.getAll();
    }

    @Override
    public void save(Customer customer, String type) {
        iSCustomerRepository.save(customer, type);
    }

//    @Override
//    public void remove(String index) {
//
//    }
}
