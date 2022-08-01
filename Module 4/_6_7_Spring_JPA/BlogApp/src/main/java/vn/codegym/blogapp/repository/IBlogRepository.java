package vn.codegym.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.blogapp.model.Blog;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select * from blog where id=:id", nativeQuery = true)
    Blog searchById(@Param("id") Long id);
}
