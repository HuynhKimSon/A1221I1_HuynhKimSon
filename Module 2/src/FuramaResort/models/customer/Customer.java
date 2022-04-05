package FuramaResort.models.customer;

import FuramaResort.models.person.Person;

public class Customer extends Person {
    /* Diamond, Platinum, Gold, Silver, Member */
    private String typeCustomer;

    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirth, int idCard, String gender, int phone, String email, String typeCustomer) {
        super(id, name, dateOfBirth, idCard, gender, phone, email);
        this.typeCustomer = typeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
