package FuramaResort.views;

import FuramaResort.controllers.EmployeeController;
import FuramaResort.models.employee.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static final String[] employeeMenuList = {"1. Display list employees", "2. Add new employee", "3. Edit employee", "4. Remove employee", "5. Return main menu"};
    static Scanner input = new Scanner(System.in);
    private static int choice;
    private static String type;


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
                    System.out.println("-----------------------------");
                    System.out.println("Danh sách nhân viên: ");
                    System.out.printf(
                            "%-20s%-30s%-30s%-50s%-30s%-30s%-30s%-30s%-30s%s",
                            "Mã nhân viên",
                            "Họ và tên",
                            "Ngày sinh",
                            "Chứng minh nhân dân",
                            "Giới tính",
                            "Số điện thoại",
                            "Email",
                            "Trình độ",
                            "Vị trí",
                            "Lương\n"
                    );
                    displayEmployee();
                    System.out.println("-----------------------------");
                    displayEmployeeMenu();
                    break;
                case 2:
                    System.out.println("Mời bạn thông tin nhân viên cần thêm mới: ");
                    Employee employeeAdd = inputInformationOfEmployee();
                    type = "INSERT";
                    employeeController.add(employeeAdd, type);
                    displayEmployeeMenu();
                    break;
                case 3:
                    System.out.println("Mời bạn thông tin nhân viên cần chỉnh sửa: ");
                    Employee employeeEdit = inputInformationOfEmployee();
                    type = "EDIT";
                    employeeController.add(employeeEdit, type);
                    displayEmployeeMenu();
                    break;
                case 4:
                    System.out.println("Mời bạn thông tin nhân viên cần xóa: ");
                    int id = removeEmployee();
                    employeeController.remove(id);
                    displayEmployeeMenu();
                    break;
                case 5:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 5);
    }

    public static void displayEmployee() {
        List<Employee> listEmployee = employeeController.display();
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.printf("%-20s%-30s%-30s%-50s%-30s%-30s%-30s%-30s%-30s%s",
                    listEmployee.get(i).getId(),
                    listEmployee.get(i).getName(),
                    listEmployee.get(i).getDateOfBirth(),
                    listEmployee.get(i).getIdCard(),
                    listEmployee.get(i).getGender(),
                    listEmployee.get(i).getPhone(),
                    listEmployee.get(i).getEmail(),
                    listEmployee.get(i).getLevel(),
                    listEmployee.get(i).getPosition(),
                    listEmployee.get(i).getSalary() + "\n"
            );
        }
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
        System.out.print("Trình độ(Trung cấp, Cao đẳng, Đại học và sau đại học): ");
        String level = input.nextLine();
        System.out.print("Vị trí(Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc): ");
        String position = input.nextLine();
        System.out.print("Lương: ");
        double salary = Double.parseDouble(input.nextLine());
        Employee employee = new Employee(id, name, dateOfBirth, idCard, gender, phone, email, level, position, salary);
        return employee;
    }

    public static int removeEmployee() {
        System.out.print("Nhập Mã nhân viên cần xóa: ");
        int id = Integer.parseInt(input.nextLine());
        return id;
    }
}
