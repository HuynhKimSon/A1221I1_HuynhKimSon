package FuramaResort.services.impl;

import FuramaResort.libs.IEmployeeRepository;
import FuramaResort.libs.impl.EmployeeRepositoryImpl;
import FuramaResort.models.employee.Employee;
import FuramaResort.services.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static int indexRemove = -1;

    private static IEmployeeRepository iSEmployeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> display() {
        return iSEmployeeRepository.display();
    }

    @Override
    public void add(Employee employee) {
        List<Employee> newEmployeeList = iSEmployeeRepository.getEmployeeList();
        for (int i = 0; i < newEmployeeList.size(); i++) {
            if (newEmployeeList.get(i).getId() == employee.getId()) {
                iSEmployeeRepository.save(false,employee.getId(), employee);
                return;
            }
        }
        iSEmployeeRepository.save(true,employee.getId(), employee);
    }

    @Override
    public void remove(int id) {
        List<Employee> newEmployeeList = iSEmployeeRepository.getEmployeeList();
        for (int i = 0; i < newEmployeeList.size(); i++) {
            if (newEmployeeList.get(i).getId() == id) {
                indexRemove = i;
                iSEmployeeRepository.remove(indexRemove, id);
                indexRemove = -1;
                return;
            }
        }
        iSEmployeeRepository.remove(indexRemove, id);
    }
}
