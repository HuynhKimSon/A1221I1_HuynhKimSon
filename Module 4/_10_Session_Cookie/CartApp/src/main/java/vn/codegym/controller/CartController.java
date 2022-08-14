package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import vn.codegym.dto.CartDto;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping()
    public String showCart(@SessionAttribute(name = "cart", required = false) CartDto cart, Model model) {
        model.addAttribute("totalAmount", String.format("%.2f", cart.totalAmount()));
        model.addAttribute("cart", cart);
        return "cart";
    }

}
