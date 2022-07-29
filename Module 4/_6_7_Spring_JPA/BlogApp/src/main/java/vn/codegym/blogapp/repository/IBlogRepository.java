package vn.codegym.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.blogapp.model.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
