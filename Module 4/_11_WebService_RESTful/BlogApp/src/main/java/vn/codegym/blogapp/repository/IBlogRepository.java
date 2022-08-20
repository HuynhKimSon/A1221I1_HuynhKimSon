package vn.codegym.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.blogapp.model.Blog;

import javax.transaction.Transactional;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    
    @Modifying
    @Transactional
    @Query(value = " delete from blog where id = :id ; ", nativeQuery = true)
    int deleteBlogById(@Param("id") Long id);
}
