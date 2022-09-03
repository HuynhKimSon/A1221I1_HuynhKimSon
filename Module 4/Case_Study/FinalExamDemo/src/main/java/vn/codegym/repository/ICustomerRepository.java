package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.customer.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
