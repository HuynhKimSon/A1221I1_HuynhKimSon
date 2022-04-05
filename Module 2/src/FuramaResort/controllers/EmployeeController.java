package FuramaResort.controllers;

import FuramaResort.models.employee.Employee;
import FuramaResort.services.impl.EmployeeServiceImpl;

public class EmployeeController {
    private static EmployeeServiceImpl iEmployeeServiceImpl = new EmployeeServiceImpl();

    public void add(Employee employee) {
        iEmployeeServiceImpl.add(employee);
    }
}
