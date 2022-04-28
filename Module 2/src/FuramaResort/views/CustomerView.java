package FuramaResort.views;

import FuramaResort.controllers.CustomerController;
import FuramaResort.models.customer.Customer;
import FuramaResort.utils.CommonUtil;
import FuramaResort.utils.Validate;

import java.util.List;

public class CustomerView {
    private static final String[] customerMenuList = {"1. Display list customers", "2. Add new customer", "3. Edit customer", "4. Return main menu"};
    private static int choice;
    private static String type;
    private static boolean isAdd;

    private static CustomerController customerController = new CustomerController();

    public static void displayCustomerMenu() {
        System.out.println("--Menu Customer Management--");
        for (String item : customerMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Danh sách khách hàng: ");
                    System.out.printf(
                            "%-30s%-30s%-30s%-50s%-30s%-30s%-30s%-30s%s",
                            "Mã khách hàng",
                            "Họ và tên",
                            "Ngày sinh",
                            "Chứng minh nhân dân",
                            "Giới tính",
                            "Số điện thoại",
                            "Email",
                            "Loại khách",
                            "Địa chỉ\n"
                    );
                    displayCustomer();
                    System.out.println("-----------------------------");
                    displayCustomerMenu();
                case 2:
                    System.out.println("Mời bạn thông tin khách hàng cần thêm mới: ");
                    isAdd = true;
                    while (isAdd) {
                        type = "INSERT";
                        Customer customerAdd = inputInformationOfCustomer(type);
                        if (!Validate.isExistsCustomer(customerAdd.getId())) {
                            customerController.save(customerAdd, type);
                            isAdd = false;
                            System.out.println("=> Thêm mới Khách hàng thành công! <=");
                        } else {
                            System.out.println("=> Mã Khách hàng đã tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayCustomerMenu();
                case 3:
                    System.out.println("Mời bạn thông tin khách hàng cần chỉnh sửa: ");
                    isAdd = true;
                    while (isAdd) {
                        type = "EDIT";
                        Customer customerAdd = inputInformationOfCustomer(type);
                        if (Validate.isExistsCustomer(customerAdd.getId())) {
                            customerController.save(customerAdd, type);
                            isAdd = false;
                            System.out.println("=> Chỉnh sửa Khách hàng thành công! <=");
                        } else {
                            System.out.println("=> Chỉnh sửa thất bại. Mã Khách hàng không tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayCustomerMenu();
                case 4:
                    FuramaView.displayMainMenu();
                default:
                    System.out.println("---> Please just input number from 1 to 4: ");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayCustomer() {
        List<Customer> customerList = customerController.display();
        for (int i = 0; i < customerList.size(); i++) {
            System.out.printf("%-30s%-30s%-30s%-50s%-30s%-30s%-30s%-30s%s",
                    customerList.get(i).getId(),
                    customerList.get(i).getName(),
                    customerList.get(i).getDateOfBirth(),
                    customerList.get(i).getIdCard(),
                    customerList.get(i).getGender(),
                    customerList.get(i).getPhone(),
                    customerList.get(i).getEmail(),
                    customerList.get(i).getTypeCustomer(),
                    customerList.get(i).getAddress() + "\n"
            );
        }
    }

    public static Customer inputInformationOfCustomer(String type) {
        List<Customer> customerList = customerController.display();
        System.out.println("-----------------------------");
        int id;
        if (type == "EDIT") {
            System.out.print("Nhập mã khách hàng: ");
            id = Integer.parseInt(CommonUtil.getScanner());
        } else {
            id = customerList.size() + 1;
        }
        System.out.print("Họ và tên: ");
        String name = CommonUtil.getScanner();
        System.out.print("Ngày sinh: ");
        String dateOfBirth = CommonUtil.getScanner();
        System.out.print("Chứng minh nhân dân: ");
        int idCard = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Giới tính (Nam/ Nữ): ");
        String gender = CommonUtil.getScanner();
        System.out.print("Số điện thoại: ");
        int phone = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Email: ");
        String email = CommonUtil.getScanner();
        System.out.print("Loại khách(Diamond, Platinium, Gold, Silver, Member): ");
        String typeCustomer = CommonUtil.getScanner();
        System.out.print("Địa chỉ: ");
        String address = CommonUtil.getScanner();
        Customer customer = new Customer(id, name, dateOfBirth, idCard, gender, phone, email, typeCustomer, address);
        return customer;
    }
}
