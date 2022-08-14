package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CartDto;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    // Khoi tao gia tri mac dinh cho session cart
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping()
    public String list(Model model, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        if (cart == null) {
            cart = new CartDto();
        }
        model.addAttribute("totalQuantity", cart.totalQuantity());
        model.addAttribute("productList", productService.findAll());
        return "product";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cartDto) {
        Product product = productService.findById(id);

        if (product != null) {

            // them object vao session
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);

            // them san pham vao productDto vao gio hang
            cartDto.addProduct(productDto);
        }
        return "redirect:/shop";
    }
}
