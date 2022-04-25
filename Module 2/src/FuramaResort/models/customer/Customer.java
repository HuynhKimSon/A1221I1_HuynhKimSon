package FuramaResort.models.customer;

import FuramaResort.models.person.Person;

public class Customer extends Person {
    /* Diamond, Platinum, Gold, Silver, Member */
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirth, int idCard, String gender, int phone, String email, String typeCustomer, String address) {
        super(id, name, dateOfBirth, idCard, gender, phone, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()
                + typeCustomer + ", "
                + address;
    }
}
