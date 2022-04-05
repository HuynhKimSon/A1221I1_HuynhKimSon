package FuramaResort.views;

import FuramaResort.controllers.EmployeeController;
import FuramaResort.models.employee.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static final String[] employeeMenuList = {"1. Display list employees", "2. Add new employee", "3. Edit employee", "4. Return main menu"};
    private static int choice;
    static Scanner input = new Scanner(System.in);

    private static EmployeeController employeeController = new EmployeeController();

    public static void displayEmployeeMenu() {
        System.out.println("--Menu Employee Management-- ");
        for (String item : employeeMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice employees Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách nhân viên: ");
                    getAllEmployee();
                    displayEmployeeMenu();
                    break;
                case 2:
                    System.out.println("Mời bạn thông tin nhân viên: ");
                    Employee employeeAdd = inputInformationOfEmployee();
                    employeeController.add(employeeAdd);
                    displayEmployeeMenu();
                    break;
                case 3:
                    System.out.println("3. Edit employee");
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static Employee inputInformationOfEmployee() {
        System.out.println("-----------------------------");
        System.out.print("Mã nhân viên: ");
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
        System.out.print("Trình độ: ");
        String level = input.nextLine();
        System.out.print("Vị trí: ");
        String position = input.nextLine();
        System.out.print("Lương: ");
        double salary = Double.parseDouble(input.nextLine());
        Employee employee = new Employee(id, name, dateOfBirth, idCard, gender, phone, email, level, position, salary);
        return employee;
    }

    public static void getAllEmployee(){
        List<Employee> list = employeeController.display();
                String result = "[ ";
        for (Employee item : list) {
            result += item.toString();
            result += "}, ";
        }
        result += " ]";
        System.out.println(result);
    }
}
