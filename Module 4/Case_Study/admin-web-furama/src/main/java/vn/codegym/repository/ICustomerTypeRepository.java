package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.customer.CustomerType;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
