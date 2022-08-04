package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthday;

    private int gender;

    private String phoneNumber;

    private String age;

    @Email(regexp = "^(.+)@(.+)$", message = "{email.notFormat}")
    private String email;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.getFirstName().isEmpty() || Integer.parseInt(String.valueOf(userDto.getFirstName().length())) < 2 ||
                Integer.parseInt(String.valueOf(userDto.getFirstName().length())) > 45) {
            errors.rejectValue("firstName", "name.notFormat");
        }

        if (userDto.getLastName().isEmpty() || Integer.parseInt(String.valueOf(userDto.getLastName().length())) < 2 ||
                Integer.parseInt(String.valueOf(userDto.getLastName().length())) > 45) {
            errors.rejectValue("lastName", "name.notFormat");
        }

        if (userDto.getBirthday().isBlank()) {
            errors.rejectValue("birthday", "notBlank");
        }

        if (userDto.getAge().isEmpty() || Integer.parseInt(userDto.getAge()) < 18) {
            errors.rejectValue("age", "age.notFormat");
        }

        if (userDto.getPhoneNumber().isBlank()) {
            errors.rejectValue("phoneNumber", "notBlank");
        }

    }
}
