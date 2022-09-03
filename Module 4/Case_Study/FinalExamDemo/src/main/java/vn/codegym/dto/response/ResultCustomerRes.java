package vn.codegym.dto.response;

import vn.codegym.model.customer.Customer;

import java.util.HashMap;
import java.util.List;

public class ResultCustomerRes {
    private Integer code;
    private HashMap<String, String> errors;
    private List<Customer> customers;

    public ResultCustomerRes() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
