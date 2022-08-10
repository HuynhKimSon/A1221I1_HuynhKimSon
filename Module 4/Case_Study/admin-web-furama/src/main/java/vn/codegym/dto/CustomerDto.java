package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;

public class CustomerDto implements Validator {
    private Long customerId;
    private Long customerTypeId;
    private String customerName;
    private String customerBirthday;
    private int customerGender;
    private Integer customerIdCard;
    private Integer customerPhone;

    @Email(regexp = "^(.+)@(.+)$", message = "{email.notFormat}")
    private String customerEmail;
    private String customerAddress;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, Long customerTypeId, String customerName, String customerBirthday, int customerGender, Integer customerIdCard, Integer customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public Integer getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(Integer customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public Integer getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Integer customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (customerDto.getCustomerName().isBlank()){
            errors.rejectValue("customerName","notBlank");
        }

        if (customerDto.getCustomerIdCard() ==  null ||customerDto.getCustomerIdCard().toString().isBlank()){
            errors.rejectValue("customerIdCard","notBlank");
        }

        if (customerDto.getCustomerIdCard() ==  null || customerDto.getCustomerPhone().toString().isBlank()){
            errors.rejectValue("customerPhone","notBlank");
        }

        if (customerDto.getCustomerBirthday().isBlank()){
            errors.rejectValue("customerBirthday","notBlank");
        }

        if (customerDto.getCustomerAddress().isBlank()){
            errors.rejectValue("customerAddress","notBlank");
        }

    }
}
