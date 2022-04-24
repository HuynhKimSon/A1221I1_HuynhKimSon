package FuramaResort.libs.impl;

import FuramaResort.libs.ICustomerRepository;
import FuramaResort.models.customer.Customer;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static final List<Customer> customerList = new LinkedList<>();

    @Override
    public List<Customer> display() {
        return customerList;
    }

    @Override
    public void save(boolean isAdd, int indexEdit, Customer customer, String type) {
        switch (type) {
            case "INSERT":
                if (isAdd) {
                    customerList.add(customer);
                    System.out.println("=> Thêm mới thành công khách hàng " + customer.getId() + " <=");
                } else {
                    System.out.println("=> Mã khách hàng " + customer.getId() + " đã tồn tại <=");
                }
                break;
            case "EDIT":
                if (isAdd) {
                    System.out.println("=> Mã khách hàng " + customer.getId() + " không tồn tại <=");
                } else {
                    customerList.set(indexEdit, customer);
                    System.out.println("=> Chỉnh sửa thành công khách hàng " + customer.getId() + " <=");
                }
                break;
        }
    }
}
