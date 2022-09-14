package vn.codegym.service.impl;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.response.ResultCustomerRes;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.service.ICustomerService;
import vn.codegym.type.SearchType;
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

    @Override
    public List<Customer> search(String key, String val) {
        if (key.equals(SearchType.NAME.value())) {
            return iCustomerRepository.findByCustomerName(val);
        }
        if (key.equals(SearchType.PHONE.value())) {
            return iCustomerRepository.findByCustomerPhone(val);
        }
        if (key.equals(SearchType.TYPE.value())) {
            return iCustomerRepository.findByCustomerType(val);
        }
        if (key.equals(SearchType.ID_CARD.value())) {
            return iCustomerRepository.findByCustomerIdCard(val);
        }
        if (key.equals(SearchType.ADDRESS.value())) {
            return iCustomerRepository.findByCustomerAddress(val);
        }
        return iCustomerRepository.findAll();
    }

    private HashMap<String, String> checkCustomer(CustomerDto customerDto) {
        HashMap<String, String> errors = new HashMap<>();

        if (customerDto.getCustomerName() == null || customerDto.getCustomerName().isBlank()) {
            errors.put("customerName", "Not blank");
        }

        if (customerDto.getCustomerBirthday() == null || customerDto.getCustomerBirthday().isBlank()) {
            errors.put("customerBirthday", "Not blank");
        }

        if (customerDto.getCustomerIdCard() == null || customerDto.getCustomerIdCard().isBlank() || !NumberUtils.isParsable(customerDto.getCustomerIdCard())) {
            errors.put("customerIdCard", "Number is required");
        }

        if (customerDto.getCustomerPhone() == null || customerDto.getCustomerPhone().isBlank() || !NumberUtils.isParsable(customerDto.getCustomerPhone())) {
            errors.put("customerPhone", "Number is required");
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
