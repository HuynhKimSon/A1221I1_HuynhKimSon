package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.customer.Customer;
import vn.codegym.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("customer", customerService.findAll());
        return "customer/customer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CustomerDto customerDto, Model model) {

        return ("redirect:/customer/customer");
    }
}
