package FuramaResort.services;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface Service {

    List<Employee> display();

    void add(Employee employee);

    void edit();

    void remove();

}