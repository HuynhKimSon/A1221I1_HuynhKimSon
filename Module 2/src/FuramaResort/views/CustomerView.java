package FuramaResort.views;

import FuramaResort.controllers.CustomerController;
import FuramaResort.models.customer.Customer;
import FuramaResort.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static final String[] customerMenuList = {"1. Display list customers", "2. Add new customer", "3. Edit customer", "4. Return main menu"};
    private static int choice;
    private static String type;
    private static boolean isAdd;
    static Scanner input = new Scanner(System.in);

    private static CustomerController customerController = new CustomerController();
    private static List<Customer> customerList = customerController.display();

    public static void displayCustomerMenu() {
        System.out.println("--Menu Customer Management--");
        for (String item : customerMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = Integer.parseInt(input.nextLine());
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
                        Customer customerAdd = inputInformationOfCustomer();
                        type = "INSERT";
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
                        Customer customerAdd = inputInformationOfCustomer();
                        type = "EDIT";
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
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayCustomer() {

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

    public static Customer inputInformationOfCustomer() {
        System.out.println("-----------------------------");
        int id = customerList.size() + 1;
        System.out.print("Họ và tên: ");
        String name = input.nextLine();
        System.out.print("Ngày sinh: ");
        String dateOfBirth = input.nextLine();
        System.out.print("Chứng minh nhân dân: ");
        int idCard = Integer.parseInt(input.nextLine());
        System.out.print("Giới tính (Nam/ Nữ): ");
        String gender = input.nextLine();
        System.out.print("Số điện thoại: ");
        int phone = Integer.parseInt(input.nextLine());
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Loại khách(Diamond, Platinium, Gold, Silver, Member): ");
        String typeCustomer = input.nextLine();
        System.out.print("Địa chỉ: ");
        String address = input.nextLine();
        Customer customer = new Customer(id, name, dateOfBirth, idCard, gender, phone, email, typeCustomer, address);
        return customer;
    }
}
