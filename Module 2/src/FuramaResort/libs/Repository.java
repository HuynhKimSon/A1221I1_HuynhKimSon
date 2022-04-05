package FuramaResort.libs;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface Repository {
    void save(boolean indexRemove, int id, Employee employee);
    List<Employee> display();
}
