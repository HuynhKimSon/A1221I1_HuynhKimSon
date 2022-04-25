package FuramaResort.repository;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface IEmployeeRepository extends BaseRepository<Employee> {

    @Override
    List<Employee> getAll();

    @Override
    void save(Employee employee, String type);
}
