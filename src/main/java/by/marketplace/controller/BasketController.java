package by.marketplace.controller;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@RequiredArgsConstructor
@Controller
public class BasketController {

    private final Basket basket;

    @GetMapping("/basket")
    public String productAddInBasket(Model model) {
        HashMap<Product, Integer> productList = basket.getProducts();
        model.addAttribute("productList", productList);
        return "basket";
    }
}

