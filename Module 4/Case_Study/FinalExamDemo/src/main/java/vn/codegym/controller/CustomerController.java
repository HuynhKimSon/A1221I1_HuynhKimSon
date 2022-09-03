package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.response.ResultCustomerRes;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.repository.service.ICustomerService;
import vn.codegym.repository.service.ICustomerTypeService;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private String prefix = "customer";

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping()
    public String processCustomer() {
        return prefix + "/customer";
    }

    @PostMapping("/list")
    public ResponseEntity<List<Customer>> getList() {
        List<Customer> list = customerService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/customerType")
    public ResponseEntity<List<CustomerType>> getCustomerType() {
        List<CustomerType> list = customerTypeService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResultCustomerRes> createCustomer(@RequestBody CustomerDto customerDto) {
        ResultCustomerRes result = customerService.save(customerDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("detail")
    public ResponseEntity<Customer> detail(@RequestParam("id") Long id) {
        Customer customer = customerService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("edit")
    public ResponseEntity<HashMap<String, Object>> edit(@RequestParam("id") Long id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("customer", customerService.findById(id));
        result.put("customerType", customerTypeService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<List<Customer>> remove(@RequestParam("id") Long id) {
        customerService.delete(id);
        List<Customer> list = customerService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
