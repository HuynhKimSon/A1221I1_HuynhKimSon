package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query("update Book b set b.quantity = :quantity where b.id = :id")
    void updateQuantity(@Param(value = "id") long id, @Param(value = "quantity") int quantity);
}
