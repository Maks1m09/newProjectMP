package by.marketplace.controller;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Product;
import by.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductControllerView {

    private final ProductService productService;

    private final Basket basket;

    @GetMapping("/product")
    public String product(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product";
    }

    @RequestMapping(value = "/product/addInBasket/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String addProductInBasket(@PathVariable(value = "id") Long id, @RequestParam(value = "total") Integer total) {
        Product product = productService.findProductById(id);
        basket.addProduct(product, total);
        return "redirect:/product";
    }

}

