package FuramaResort.services;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> display();

    void add(Employee employee, String type);

    void remove(int id);
}
