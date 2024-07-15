package by.marketplace.controller;

import by.marketplace.entity.Product;
import by.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping ("/product/save")
    public String saveProductGet (Product product){
          return "saveProduct";
    }

    @PostMapping ("/product/save")
    public String saveProductPost (@RequestBody Product product){
        productService.saveProduct(product);
        return "redirect:/home";
    }

    @GetMapping("/")
  public String seeAllProduct (Model model){
        model.addAttribute("products", productService.findAllProducts());
        return "home";
    }

    @GetMapping("/delete/{id}")
  public String deleteBookById (@PathVariable(value = "id") Long id){
      productService.deleteProductById(id);
      return "redirect:/home";
  }
    @GetMapping("/edit/{id}")
      public String showCreateBook(@PathVariable(value = "id") Long id, Model model ){
        Optional<Product> product = productService.findProductById(id);
        model.addAttribute("products", product);
        return "update-product";
      }
//добавить в конструктор и переадресац
    @GetMapping("/update/{id}")
    public String createBook(@PathVariable(value = "id") Long id, Model model ){
        Optional<Product> product = productService.findProductById(id);
        productService.createProduct("");
        model.addAttribute("products", product);
        return "/home";
    }

    }