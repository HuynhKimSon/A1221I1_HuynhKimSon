package vn.codegym.blogapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.blogapp.model.Blog;
import vn.codegym.blogapp.repository.IBlogRepository;
import vn.codegym.blogapp.service.IBlogService;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void deleteBlogById(Long id) {
        blogRepository.deleteBlogById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

}
