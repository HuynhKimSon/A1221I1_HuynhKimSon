package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Song;
import vn.codegym.service.IMusicService;

@Controller
@RequestMapping("/song")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("list", musicService.findAll());
        model.addAttribute("song", new Song());
        return "list";
    }

    @PostMapping("")
    public String create(@ModelAttribute Song song,
                         RedirectAttributes redirectAttributes) {
        musicService.save(song);
        return "redirect:/list";
    }
}
