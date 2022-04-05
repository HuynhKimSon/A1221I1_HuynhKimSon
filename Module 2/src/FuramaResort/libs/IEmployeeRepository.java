package FuramaResort.libs;

import FuramaResort.models.employee.Employee;

public interface IEmployeeRepository extends Repository {
    @Override
    void save(Employee employee);

}
