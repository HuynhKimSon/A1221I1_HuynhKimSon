package FuramaResort.services;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface IEmployeeService extends Service {
    @Override
    List<Employee> display();

    @Override
    void add(Employee employee);

    @Override
    void edit();

    @Override
    void remove();
}
