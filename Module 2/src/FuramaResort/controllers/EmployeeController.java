package FuramaResort.controllers;

import FuramaResort.models.employee.Employee;
import FuramaResort.services.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private EmployeeServiceImpl iEmployeeServiceImpl = new EmployeeServiceImpl();

    public List<Employee> display() {
        return iEmployeeServiceImpl.getAll();
    }

    public void save(Employee employee, String type) {
        iEmployeeServiceImpl.save(employee, type);
    }
}
