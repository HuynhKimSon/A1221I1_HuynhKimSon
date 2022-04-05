package FuramaResort.libs.impl;

import FuramaResort.libs.IEmployeeRepository;
import FuramaResort.models.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void save(boolean isAdd,int id, Employee employee) {
        if (isAdd){
            employeeList.add(employee);
            System.out.println("=> Thêm mới thành công nhân viên " + id);
        } else {
            System.out.println("=> Mã nhân viên " + id + " đã tồn tại");
        }
    }

    @Override
    public List<Employee> display() {
        return employeeList;
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
