package FuramaResort.models.employee;

import FuramaResort.models.person.Person;

public class Employee extends Person {
    /* Trung cấp, Cao đẳng, Đại học và sau đại học */
    private String level;
    /* Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc. */
    private String position;

    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, int idCard, String gender, int phone, String email, String level, String position, double salary) {
        super(id, name, dateOfBirth, idCard, gender, phone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", level: '" + level + '\'' +
                ", position: '" + position + '\'' +
                ", salary: " + salary +
                '}';
    }

    public String getLevel() {
        return level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
