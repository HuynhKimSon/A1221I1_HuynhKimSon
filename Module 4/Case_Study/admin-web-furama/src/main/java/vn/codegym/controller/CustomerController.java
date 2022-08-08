package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String list(Model model, CustomerDto customerDto, BindingResult bindingResult) {
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("isError", bindingResult.hasFieldErrors());
        model.addAttribute("isDetail", false);
        return "customer/customer";
    }

    @PostMapping("")
    public String create(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model) {

        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return list(model, customerDto, bindingResult);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return ("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {

        Customer customer = customerService.findById(id);
        String customerTypeName = customer.getCustomerType().getCustomerTypeName();

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerTypeName", customerTypeName);
        model.addAttribute("isError", false);
        return "customer/customer";
    }
}
