package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.customer.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_name LIKE CONCAT('%',?1,'%')", nativeQuery = true)
    List<Customer> findByCustomerName(@Param("val") String val);

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_phone LIKE CONCAT(?1,'%')", nativeQuery = true)
    List<Customer> findByCustomerPhone(@Param("val") String val);

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_id_card LIKE CONCAT(?1,'%')", nativeQuery = true)
    List<Customer> findByCustomerIdCard(@Param("val") String val);

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_address LIKE CONCAT('%',?1,'%')", nativeQuery = true)
    List<Customer> findByCustomerAddress(@Param("val") String val);

    @Query(value = "SELECT * FROM CUSTOMER INNER JOIN CUSTOMER_TYPE ON CUSTOMER.CUSTOMER_TYPE_ID = CUSTOMER_TYPE.CUSTOMER_TYPE_ID WHERE CUSTOMER_TYPE_NAME LIKE CONCAT('%',?1,'%')", nativeQuery = true)
    List<Customer> findByCustomerType(@Param("val") String val);
}
