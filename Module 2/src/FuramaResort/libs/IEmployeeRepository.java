package FuramaResort.libs;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface IEmployeeRepository extends Repository {
    List<Employee> getEmployeeList();

    @Override
    void save(boolean indexRemove, int id, Employee employee);

    @Override
    List<Employee> display();

    void remove(int indexRemove, int id);
}
