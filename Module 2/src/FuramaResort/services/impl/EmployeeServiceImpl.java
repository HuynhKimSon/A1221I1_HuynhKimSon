package FuramaResort.services.impl;

import FuramaResort.libs.IEmployeeRepository;
import FuramaResort.libs.impl.EmployeeRepositoryImpl;
import FuramaResort.models.employee.Employee;
import FuramaResort.services.IEmployeeService;



public class EmployeeServiceImpl implements IEmployeeService {

    private static IEmployeeRepository iSEmployeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void display() {

    }

    @Override
    public void add(Employee employee) {
        iSEmployeeRepository.save(employee);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }
}
