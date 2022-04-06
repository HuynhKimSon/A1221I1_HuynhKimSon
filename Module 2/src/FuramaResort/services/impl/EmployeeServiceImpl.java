package FuramaResort.services.impl;

import FuramaResort.libs.IEmployeeRepository;
import FuramaResort.libs.impl.EmployeeRepositoryImpl;
import FuramaResort.models.employee.Employee;
import FuramaResort.services.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static int currentIndex = -1;
    private static IEmployeeRepository iSEmployeeRepository = new EmployeeRepositoryImpl();
    List<Employee> employeeList = iSEmployeeRepository.display();

    @Override
    public List<Employee> display() {
        return employeeList;
    }

    @Override
    public void add(Employee employee, String type) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == employee.getId()) {
                currentIndex = i;
                iSEmployeeRepository.save(false, currentIndex, employee, type);
                currentIndex = -1;
                return;
            }
        }
        iSEmployeeRepository.save(true, currentIndex, employee, type);
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                currentIndex = i;
                iSEmployeeRepository.remove(currentIndex, id);
                currentIndex = -1;
                return;
            }
        }
        iSEmployeeRepository.remove(currentIndex, id);
    }
}
