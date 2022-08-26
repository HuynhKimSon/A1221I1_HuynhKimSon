package vn.codegym.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Value("${file-upload}")
    private String uploadFolder;

    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public String processBlog() {
        return "blog";
    }

    @PostMapping("/list")
    public ResponseEntity<List<Blog>> list() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<Blog>> create(@RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("content") String content, @RequestParam("image") MultipartFile fileName) {
        try {
            FileCopyUtils.copy(fileName.getBytes(), new File(uploadFolder + fileName.getOriginalFilename()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setAuthor(author);
        blog.setContent(content);
        blog.setCreateTime(LocalDate.now().toString());
        blog.setImage(fileName.getOriginalFilename());
        if (blogService.findById(Long.parseLong(id)) != null) {
            blog.setId(Long.parseLong(id));
        }
        blogService.save(blog);
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<List<Blog>> delete(@RequestParam("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteBlogById(id);
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> detail(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
