package FuramaResort.services;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface IEmployeeService extends BaseService<Employee> {

    @Override
    List<Employee> getAll();

    @Override
    void save(Employee employee, String type);

}
