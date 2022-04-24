package FuramaResort.services.impl;

import FuramaResort.repository.ICustomerRepository;
import FuramaResort.repository.impl.CustomerRepositoryImpl;
import FuramaResort.models.customer.Customer;
import FuramaResort.services.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private static int currentIndex = -1;
    private static ICustomerRepository iSCustomerRepository = new CustomerRepositoryImpl();
    List<Customer> customerList = iSCustomerRepository.display();

    @Override
    public List<Customer> display() {
        return customerList;
    }

    @Override
    public void add(Customer customer, String type) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == customer.getId()) {
                currentIndex = i;
                iSCustomerRepository.save(false, currentIndex, customer, type);
                currentIndex = -1;
                return;
            }
        }
        iSCustomerRepository.save(true, currentIndex, customer, type);
    }
}
