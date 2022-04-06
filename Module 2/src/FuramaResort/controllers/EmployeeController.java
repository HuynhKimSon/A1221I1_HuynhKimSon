package FuramaResort.controllers;

import FuramaResort.models.employee.Employee;
import FuramaResort.services.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private static EmployeeServiceImpl iEmployeeServiceImpl = new EmployeeServiceImpl();

    public List<Employee> display() {
        return iEmployeeServiceImpl.display();
    }

    public void add(Employee employee, String type) {
        iEmployeeServiceImpl.add(employee, type);
    }

    public void remove(int id) {
        iEmployeeServiceImpl.remove(id);
    }
}
