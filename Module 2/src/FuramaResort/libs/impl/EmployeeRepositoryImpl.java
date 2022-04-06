package FuramaResort.libs.impl;

import FuramaResort.libs.IEmployeeRepository;
import FuramaResort.models.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> display() {
        return employeeList;
    }

    @Override
    public void save(boolean isAdd, int indexEdit, Employee employee, String type) {
        switch (type) {
            case "INSERT":
                if (isAdd) {
                    employeeList.add(employee);
                    System.out.println("=> Thêm mới thành công nhân viên " + employee.getId() + " <=");
                } else {
                    System.out.println("=> Mã nhân viên " + employee.getId() + " đã tồn tại <=");
                }
                break;
            case "EDIT":
                if (isAdd) {
                    System.out.println("=> Mã nhân viên " + employee.getId() + " không tồn tại <=");
                } else {
                    employeeList.set(indexEdit, employee);
                    System.out.println("=> Chỉnh sửa thành công nhân viên " + employee.getId() + " <=");
                }
                break;
        }
    }
    
    @Override
    public void remove(int indexRemove, int id) {
        if (indexRemove == -1) {
            System.out.println("=> Mã nhân viên " + id + " không tồn tại");
        } else {
            employeeList.remove(indexRemove);
            System.out.println("=> Xóa thành công nhân viên " + id);
        }
    }
}
