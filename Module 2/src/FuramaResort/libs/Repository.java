package FuramaResort.libs;

import FuramaResort.models.employee.Employee;

import java.util.List;

public interface Repository {
    List<Employee> display();

    void save(boolean isAdd, int indexEdit, Employee employee, String type);

    void remove(int currentIndex, int id);
}
