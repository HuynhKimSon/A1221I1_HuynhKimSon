package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String list(Model model, CustomerDto customerDto, boolean bindingResult, String action, @PageableDefault(value = 10) Pageable pageable) {

        Page findPage = customerService.findPage(pageable);

        model.addAttribute("customer", findPage);
        model.addAttribute("customerTotalPage", findPage.getTotalPages());
        model.addAttribute("customerPageSize", findPage.getSize());
        model.addAttribute("customerTotal", customerService.findAll().size());
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("isError", bindingResult);
        model.addAttribute("action", action);
        return "customer/customer";
    }

    @PostMapping("")
        public String create(Model model, @ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, @PageableDefault(value = 10) Pageable pageable) {

        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return list(model, customerDto, bindingResult.hasFieldErrors(), "", pageable);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = customerTypeService.findById(customerDto.getCustomerTypeId());
        customer.setCustomerType(customerType);

        customerService.save(customer);
        return list(model, customerDto, false, "CREATE", pageable);
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id, @PageableDefault(value = 10) Pageable pageable) {
        customerService.delete(id);
        return list(model, new CustomerDto(), false, "DELETE", pageable);
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id, @PageableDefault(value = 10) Pageable pageable) {

        Customer customer = customerService.findById(id);
        String customerTypeName = customer.getCustomerType().getCustomerTypeName();

        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(customer, customerDto);

        Page findPage = customerService.findPage(pageable);

        model.addAttribute("customer", findPage);
        model.addAttribute("customerTotalPage", findPage.getTotalPages());
        model.addAttribute("customerPageSize", findPage.getSize());
        model.addAttribute("customerTotal", customerService.findAll().size());
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeName", customerTypeName);
        model.addAttribute("isError", false);
        model.addAttribute("action", "DETAIL");
        return "customer/customer";
    }

}
