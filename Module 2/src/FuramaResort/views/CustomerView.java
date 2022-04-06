package FuramaResort.views;

import FuramaResort.controllers.CustomerController;
import FuramaResort.models.customer.Customer;
import FuramaResort.models.employee.Employee;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static final String[] customerMenuList = {"1. Display list customers", "2. Add new customer", "3. Edit customer", "4. Return main menu"};
    static Scanner input = new Scanner(System.in);
    private static int choice;
    private static String type;

    private static CustomerController customerController = new CustomerController();

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
                    break;
                case 2:
                    System.out.println("Mời bạn thông tin khách hàng cần thêm mới: ");
                    Customer customerAdd = inputInformationOfCustomer();
                    type = "INSERT";
                    customerController.add(customerAdd, type);
                    displayCustomerMenu();
                    break;
                case 3:
                    System.out.println("Mời bạn thông tin khách hàng cần chỉnh sửa: ");
                    Customer customerEdit = inputInformationOfCustomer();
                    type = "EDIT";
                    customerController.add(customerEdit, type);
                    displayCustomerMenu();
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayCustomer() {
        List<Customer> listCustomer = customerController.display();
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.printf("%-30s%-30s%-30s%-50s%-30s%-30s%-30s%-30s%s",
                    listCustomer.get(i).getId(),
                    listCustomer.get(i).getName(),
                    listCustomer.get(i).getDateOfBirth(),
                    listCustomer.get(i).getIdCard(),
                    listCustomer.get(i).getGender(),
                    listCustomer.get(i).getPhone(),
                    listCustomer.get(i).getEmail(),
                    listCustomer.get(i).getTypeCustomer(),
                    listCustomer.get(i).getAddress() + "\n"
            );
        }
    }

    public static Customer inputInformationOfCustomer() {
        System.out.println("-----------------------------");
        System.out.print("Mã khách hàng: ");
        int id = Integer.parseInt(input.nextLine());
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
