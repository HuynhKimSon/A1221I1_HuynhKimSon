package FuramaResort.utils;

import FuramaResort.services.ICustomerService;
import FuramaResort.services.IEmployeeService;
import FuramaResort.services.IFacilityService;
import FuramaResort.services.impl.CustomerServiceImpl;
import FuramaResort.services.impl.EmployeeServiceImpl;
import FuramaResort.services.impl.FacilityServiceImpl;

public class Validate {
    private static IFacilityService facilityService = new FacilityServiceImpl();
    private static ICustomerService customerService = new CustomerServiceImpl();
    private static IEmployeeService employeeService = new EmployeeServiceImpl();

    public static boolean isExistsFacility(String id) {
        return facilityService.getAll().stream().anyMatch(e -> e.getIdService().equals(id));
    }

    public static boolean isExistsCustomer(int id) {
        return customerService.getAll().stream().anyMatch(e -> e.getId() == id);
    }

    public static boolean isExistsEmployee(int id){
        return employeeService.getAll().stream().anyMatch(e -> e.getId() == id);
    }
}
