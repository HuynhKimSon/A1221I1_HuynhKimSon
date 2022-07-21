package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Email;
import vn.codegym.service.IEmailService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("list", emailService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Email email = new Email();

        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        model.addAttribute("email", email);
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "Setting Success!");
        emailService.save(email);

        return "redirect:/";
    }
}
