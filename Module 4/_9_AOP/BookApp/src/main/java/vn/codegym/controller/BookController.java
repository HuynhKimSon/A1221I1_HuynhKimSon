package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Book;
import vn.codegym.service.IBookService;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping()
    public String list(Model model, Book book, boolean isError, boolean isSuccess, String msgError) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("book", book);
        model.addAttribute("isError", isError);
        model.addAttribute("msgError", msgError);
        model.addAttribute("isSuccess", isSuccess);
        return "book";
    }

    @PostMapping("/borrow")
    public String borrow(Model model, @ModelAttribute Book request) {
        try {
            bookService.borrowBook(request);
        } catch (Exception exception) {
            Book book = bookService.findById(request.getId());
            return list(model, book, true, false, exception.getMessage());
        }
        return list(model, new Book(), false, true, "Successfully !");
    }

    @PostMapping("/pay")
    public String pay(Model model, @ModelAttribute Book request) {
        try {
            bookService.payBook(request);
        } catch (Exception exception) {
            Book book = bookService.findById(request.getId());
            return list(model, book, true, false, exception.getMessage());
        }
        return list(model, new Book(), false, true, "Successfully !");
    }
}
