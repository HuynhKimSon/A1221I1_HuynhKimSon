package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Caculator {

    @GetMapping("/")
    public String list() {
        return "index";
    }

    @PostMapping("/")
    public String calculate(@RequestParam double value1, double value2, String operator, Model model) {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            default:
                result = value1 / value2;
                break;
        }
        if (value2 == 0) {
            model.addAttribute("result", "Không thể chia cho 0");
        } else {
            model.addAttribute("result", result);
        }
        return "index";
    }
}
