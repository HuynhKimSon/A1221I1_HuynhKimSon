package vn.codegym.model.customer;


import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;

    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customer;

    public CustomerType() {
    }

    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
