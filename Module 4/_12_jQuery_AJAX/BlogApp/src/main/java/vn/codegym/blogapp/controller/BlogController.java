package vn.codegym.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.blogapp.model.Blog;
import vn.codegym.blogapp.model.BlogForm;
import vn.codegym.blogapp.service.IBlogService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Value("${file-upload}")
    private String uploadFolder;

    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public String processBlog() {
        return "index";
    }

    @PostMapping()
    public ResponseEntity<List<Blog>> list() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@ModelAttribute BlogForm blogForm) {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(uploadFolder + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Blog blog = new Blog();
        blog.setTitle(blogForm.getTitle());
        blog.setAuthor(blogForm.getAuthor());
        blog.setContent(blogForm.getContent());
        blog.setCreateTime(LocalDate.now().toString());
        blog.setImage(fileName);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/detail")
    public ResponseEntity<Blog> viewDetail(@RequestParam("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
