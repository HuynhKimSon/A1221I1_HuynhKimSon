package FuramaResort.services;

import FuramaResort.models.employee.Employee;

public interface IEmployeeService extends Service {
    @Override
    void display();

    @Override
    void add(Employee employee);

    @Override
    void edit();

    @Override
    void remove();
}
