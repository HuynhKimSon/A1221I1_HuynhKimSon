package FuramaResort.libs.impl;

import FuramaResort.libs.IEmployeeRepository;
import FuramaResort.models.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public void save(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> display(){
        return employeeList;
    }
}
