package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.customer.Customer;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private String prefix = "customer";

    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public String processCustomer() {
        return prefix + "/customer";
    }

    @PostMapping("/list")
    public ResponseEntity<List<Customer>> list() {
        List<Customer> list = customerService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
