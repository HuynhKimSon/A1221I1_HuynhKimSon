package FuramaResort.controllers;

import FuramaResort.models.employee.Employee;
import FuramaResort.services.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private static EmployeeServiceImpl iEmployeeServiceImpl = new EmployeeServiceImpl();

    public void add(Employee employee) {
        iEmployeeServiceImpl.add(employee);
    }

    public List<Employee> display() {
        return iEmployeeServiceImpl.display();
    }

    public void remove(int id){
        iEmployeeServiceImpl.remove(id);
    }
}
