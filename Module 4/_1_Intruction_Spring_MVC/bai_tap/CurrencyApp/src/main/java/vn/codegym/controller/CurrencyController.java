package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String convert() {
        return "index";
    }

    @PostMapping ("/")
    public String convert(@RequestParam int value, Model model) {
        Double result = value * 23000.0;
        model.addAttribute("result", result);
        return "index";
    }
}
