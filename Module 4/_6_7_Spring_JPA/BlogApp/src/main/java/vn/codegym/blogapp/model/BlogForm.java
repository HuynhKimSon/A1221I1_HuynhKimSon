package vn.codegym.blogapp.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;

    private String title;

    private String content;

    private String createTime;

    private String author;

    private MultipartFile image;

    public BlogForm() {
    }

    public BlogForm(Long id, String title, String content, String createTime, String author, MultipartFile image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.author = author;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
