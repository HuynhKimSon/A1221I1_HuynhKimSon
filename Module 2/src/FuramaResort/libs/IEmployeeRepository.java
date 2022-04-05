package FuramaResort.libs;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface IEmployeeRepository extends Repository {
    @Override
    void save(Employee employee);

    @Override
    List<Employee> display();
}
