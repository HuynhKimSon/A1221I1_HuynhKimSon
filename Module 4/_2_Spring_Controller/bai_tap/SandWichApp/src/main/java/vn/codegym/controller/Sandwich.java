package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {
    @GetMapping
    public String list(){
        return "index";
    }
    @PostMapping
    public String save(@RequestParam String[] condiment, ModelMap modelmap){
        modelmap.put("condiment", condiment);
        return "list";
    }
}
