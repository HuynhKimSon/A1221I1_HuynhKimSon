package vn.codegym.repository.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.response.ResultCustomerRes;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.repository.service.ICustomerService;
import vn.codegym.type.StatusType;

import java.util.HashMap;
import java.util.List;


@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(new Customer());
    }

    @Override
    public ResultCustomerRes save(CustomerDto customerDto) {
        // Validate
        ResultCustomerRes resultCustomerRes = new ResultCustomerRes();
        HashMap<String, String> listError = checkCustomer(customerDto);
        if (listError.size() > 0) {
            resultCustomerRes.setCode(StatusType.FAIL.value());
            resultCustomerRes.setErrors(listError);
            return resultCustomerRes;
        }

        // Convert customerDto into customer
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(Long.parseLong((customerDto.getCustomerTypeId())));
        customer.setCustomerType(customerType);

        // Save
        iCustomerRepository.save(customer);
        // Set result
        resultCustomerRes.setCode(StatusType.SUCCESS.value());
        resultCustomerRes.setCustomers(iCustomerRepository.findAll());
        return resultCustomerRes;
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }

    private HashMap<String, String> checkCustomer(CustomerDto customerDto) {
        HashMap<String, String> errors = new HashMap<>();

        if (customerDto.getCustomerName() == null || customerDto.getCustomerName().isBlank()) {
            errors.put("customerName", "Not blank");
        }
        if (customerDto.getCustomerBirthday() == null || customerDto.getCustomerBirthday().isBlank()) {
            errors.put("customerBirthday", "Not blank");
        }
        if (customerDto.getCustomerIdCard() == null || customerDto.getCustomerIdCard().isBlank()) {
            errors.put("customerIdCard", "Not blank");
        }
        if (customerDto.getCustomerPhone() == null || customerDto.getCustomerPhone().isBlank()) {
            errors.put("customerPhone", "Not blank");
        }
        if (customerDto.getCustomerEmail() == null || customerDto.getCustomerEmail().isBlank()) {
            errors.put("customerEmail", "Not blank");
        }
        if (customerDto.getCustomerAddress() == null || customerDto.getCustomerAddress().isBlank()) {
            errors.put("customerAddress", "Not blank");
        }
        if (customerDto.getCustomerTypeId() == null || customerDto.getCustomerTypeId().isBlank()) {
            errors.put("customerTypeName", "Not blank");
        }

        return errors;
    }
}
