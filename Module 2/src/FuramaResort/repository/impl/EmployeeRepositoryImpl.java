package FuramaResort.repository.impl;

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
        List<Employee> res = new ArrayList<>();
        List<String> stringList = employeeFileCSVHelper.read(ConstantUtil.PATH.EMPLOYEE);
        for (int i = 0; i < stringList.size(); i++) {
            String[] strings = stringList.get(i).split(",");
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            String dateOfBirth = strings[2];
            int idCard = Integer.parseInt(strings[3]);
            String gender = strings[4];
            int phone = Integer.parseInt(strings[5]);
            String email = strings[6];
            String level = strings[7];
            String position = strings[8];
            double salary = Double.parseDouble(strings[9]);
            Employee employee = new Employee(id, name, dateOfBirth, idCard, gender, phone, email, level, position, salary);
            res.add(employee);
        }
        return res;
    }

    @Override
    public void save(Employee employee, String type) {
        switch (type) {
            case "INSERT":
                employeeList.add(employee);
                employeeFileCSVHelper.write(employeeList, ConstantUtil.PATH.EMPLOYEE, true);
                employeeList.clear();
                break;
            case "EDIT":
                employeeList.add(employee);
                employeeFileCSVHelper.edit(employeeList, ConstantUtil.PATH.EMPLOYEE, true);
                employeeList.clear();
                break;
        }
    }
}
