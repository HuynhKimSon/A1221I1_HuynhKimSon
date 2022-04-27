package FuramaResort.services.impl;

import FuramaResort.repository.IEmployeeRepository;
import FuramaResort.repository.impl.EmployeeRepositoryImpl;
import FuramaResort.models.employee.Employee;
import FuramaResort.services.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeRepository iSEmployeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> getAll() {
        return iSEmployeeRepository.getAll();
    }

    @Override
    public void save(Employee employee, String type) {
        iSEmployeeRepository.save(employee, type);
    }
}
