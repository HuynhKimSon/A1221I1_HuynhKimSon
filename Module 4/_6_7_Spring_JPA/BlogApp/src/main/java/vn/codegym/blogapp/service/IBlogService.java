package vn.codegym.blogapp.service;

import vn.codegym.blogapp.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(Long id);

    void deleteBlogById(Long id);

    void save(Blog blog);

}
