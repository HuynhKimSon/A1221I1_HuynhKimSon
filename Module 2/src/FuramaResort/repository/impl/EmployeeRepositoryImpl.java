package FuramaResort.repository.impl;

import FuramaResort.models.customer.Customer;
import FuramaResort.repository.IEmployeeRepository;
import FuramaResort.models.employee.Employee;
import FuramaResort.utils.ConstantUtil;
import FuramaResort.utils.FileCSVHelper;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private FileCSVHelper<Employee> employeeFileCSVHelper = new FileCSVHelper<>();
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public void save(Employee employee, String type) {
        switch (type) {
            case "INSERT":
                employeeList.add(employee);
                employeeFileCSVHelper.write(employeeList, ConstantUtil.PATH.EMPLOYEE, true);
                break;
            case "EDIT":
                break;
        }
    }

}
