package FuramaResort.repository.impl;

import FuramaResort.repository.ICustomerRepository;
import FuramaResort.models.customer.Customer;
import FuramaResort.utils.ConstantUtil;
import FuramaResort.utils.FileCSVHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private FileCSVHelper<Customer> customerFileCSVHelper = new FileCSVHelper<>();
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer, String type) {
        switch (type) {
            case "INSERT":
                customerList.add(customer);
                customerFileCSVHelper.write(customerList, ConstantUtil.PATH.CUSTOMER, true);
                break;
            case "EDIT":
                break;
        }
    }
}
