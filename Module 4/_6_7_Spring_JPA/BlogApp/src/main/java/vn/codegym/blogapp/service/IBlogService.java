package vn.codegym.blogapp.service;

import vn.codegym.blogapp.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

}
