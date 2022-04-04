package demo_mvc.controller;

import demo_mvc.model.Student;
import demo_mvc.service.IStudentService;
import demo_mvc.service.impl.StudentService;

public class StudentController {
    // DI
    private static IStudentService iStudentService = new StudentService();
    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }
}
