package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {

    @GetMapping("/")
    public String convert() {
        return "index";
    }

    @PostMapping("/")
    public String convert(@RequestParam String value, Model model) {
        String result = "Không tìm thấy!";
        HashMap<String, String> translate = new HashMap<>();
        translate.put("dog", "Chó");
        translate.put("cat", "Mèo");
        translate.put("fish", "Cá");
        translate.put("bird", "Chim");
        for (Map.Entry<String, String> entry : translate.entrySet()) {
            if (value.equals(entry.getKey())) {
                result = entry.getValue();
            }
        }
        model.addAttribute("result", result);
        return "index";
    }
}
