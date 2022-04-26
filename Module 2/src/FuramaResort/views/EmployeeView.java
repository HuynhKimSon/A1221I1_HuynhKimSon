package FuramaResort.views;

import FuramaResort.controllers.EmployeeController;
import FuramaResort.models.employee.Employee;
import FuramaResort.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static final String[] employeeMenuList = {"1. Display list employees", "2. Add new employee", "3. Edit employee", "4. Remove employee", "5. Return main menu"};
    private static int choice;
    private static String type;
    private static boolean isAdd;
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
                case 2:
                    System.out.println("Mời bạn thông tin nhân viên cần thêm mới: ");
                    isAdd = true;
                    while (isAdd) {
                        Employee employeeAdd = inputInformationOfEmployee();
                        type = "INSERT";
                        if (!Validate.isExistsEmployee(employeeAdd.getId())) {
                            employeeController.save(employeeAdd, type);
                            isAdd = false;
                            System.out.println("=> Thêm mới Nhân viên thành công! <=");
                        } else {
                            System.out.println("=> Mã Nhân viên đã tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayEmployeeMenu();
                case 3:
                    System.out.println("Mời bạn thông tin nhân viên cần chỉnh sửa: ");
                    isAdd = true;
                    while (isAdd) {
                        Employee employeeAdd = inputInformationOfEmployee();
                        type = "EDIT";
                        if (Validate.isExistsEmployee(employeeAdd.getId())) {
                            employeeController.save(employeeAdd, type);
                            isAdd = false;
                            System.out.println("=> Chỉnh sửa Nhân viên thành công! <=");
                        } else {
                            System.out.println("=> Chỉnh sửa thất bại. Mã Nhân viên đã tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayEmployeeMenu();
                case 4:
                    System.out.println("Mời bạn thông tin nhân viên cần xóa: ");
                    int id = removeEmployee();
                    displayEmployeeMenu();
                case 5:
                    FuramaView.displayMainMenu();
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 5);
    }

    public static void displayEmployee() {
        List<Employee> employeeList = employeeController.display();
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.printf("%-20s%-30s%-30s%-50s%-30s%-30s%-30s%-30s%-30s%s",
                    employeeList.get(i).getId(),
                    employeeList.get(i).getName(),
                    employeeList.get(i).getDateOfBirth(),
                    employeeList.get(i).getIdCard(),
                    employeeList.get(i).getGender(),
                    employeeList.get(i).getPhone(),
                    employeeList.get(i).getEmail(),
                    employeeList.get(i).getLevel(),
                    employeeList.get(i).getPosition(),
                    employeeList.get(i).getSalary() + "\n"
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
