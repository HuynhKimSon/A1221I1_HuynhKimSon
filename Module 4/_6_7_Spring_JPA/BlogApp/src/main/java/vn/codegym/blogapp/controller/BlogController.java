package vn.codegym.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@Controller
@RequestMapping("/")
public class BlogController {

    @Value("${file-upload}")
    private String uploadFolder;

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        model.addAttribute("blogForm", new BlogForm());
        model.addAttribute("blog", new Blog());
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogForm blogForm) {
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
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.deleteBlogById(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("blogForm", new BlogForm());
        model.addAttribute("blog", blogService.findById(id));
        return "index";
    }
}
