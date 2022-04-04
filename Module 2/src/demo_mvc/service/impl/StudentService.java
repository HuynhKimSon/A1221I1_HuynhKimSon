package demo_mvc.service.impl;

import demo_mvc.model.Student;
import demo_mvc.repository.IStudentRepository;
import demo_mvc.repository.impl.StudentRepository;
import demo_mvc.service.IStudentService;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if(student.getPoint()<0) {

        } else {
            iStudentRepository.saveStudent(student);
        }
    }
}
