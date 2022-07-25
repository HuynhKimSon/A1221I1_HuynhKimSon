package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.service.IServiceProduct;

@Controller
@RequestMapping("/product")
public class StudentController {

    @Autowired
    private IServiceProduct serviceProduct;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("list", serviceProduct.findAll());
        return "list";
    }
}
