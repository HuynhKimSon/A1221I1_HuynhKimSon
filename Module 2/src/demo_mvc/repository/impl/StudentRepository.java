package demo_mvc.repository.impl;

import demo_mvc.model.Student;
import demo_mvc.repository.IStudentRepository;

public class StudentRepository implements IStudentRepository {
   private static Student[] students = new Student[1000];
   private static int numberPeopleOfCompany =0;
    @Override
    public void saveStudent(Student student) {
        students[numberPeopleOfCompany] = student;
        numberPeopleOfCompany++;
    }
}
