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
        List<Customer> res = new ArrayList<>();
        List<String> stringList = customerFileCSVHelper.read(ConstantUtil.PATH.CUSTOMER);
        for (int i = 0; i < stringList.size(); i++) {
            String[] strings = stringList.get(i).split(",");
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            String dateOfBirth = strings[2];
            int idCard = Integer.parseInt(strings[3]);
            String gender = strings[4];
            int phone = Integer.parseInt(strings[5]);
            String email = strings[6];
            String typeCustomer = strings[7];
            String address = strings[8];
            Customer customer = new Customer(id, name, dateOfBirth, idCard, gender, phone, email, typeCustomer, address);
            res.add(customer);
        }
        return res;
    }

    @Override
    public void save(Customer customer, String type) {
        switch (type) {
            case "INSERT":
                customerList.add(customer);
                customerFileCSVHelper.write(customerList, ConstantUtil.PATH.CUSTOMER, true);
                customerList.clear();
                break;
            case "EDIT":
                customerList.add(customer);
                customerFileCSVHelper.edit(customerList, ConstantUtil.PATH.CUSTOMER, false);
                customerList.clear();
                break;
        }
    }

//    @Override
//    public void remove(String index) {
//
//    }
}
