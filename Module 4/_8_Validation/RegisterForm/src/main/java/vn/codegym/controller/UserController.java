package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.dto.UserDto;
import vn.codegym.model.User;
import vn.codegym.service.IUserService;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping({"", "/user"})
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user";
    }

    @PostMapping("/user")
    public String create(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult) {

        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "user";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "result";
    }

}
