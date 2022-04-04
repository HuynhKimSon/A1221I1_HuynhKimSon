package demo_mvc.view;

import demo_mvc.controller.StudentController;
import demo_mvc.model.Student;

import java.util.Scanner;

public class StudentView {
    static Scanner scanner = new Scanner(System.in);
    private static StudentController studentController = new StudentController();

    public static void main(String[] args) {
        System.out.println("Chào mừng bạn đến với trang web quản lí học sinh");
        while(true) {
            System.out.println("1.Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:

                    break;
                case 2:
                    Student student = inputInformationOfStudent();
                    studentController.addStudent(student);
                    break;
            }
        }
    }

    private static Student inputInformationOfStudent() {
        System.out.print("Mời bạn nhập tên của học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của học sinh: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập ngày tháng năm sinh của học sinh: ");
        String dateOfBirth = scanner.nextLine();
        Student student = new Student(name, point, dateOfBirth);
        return student;
    }
}
