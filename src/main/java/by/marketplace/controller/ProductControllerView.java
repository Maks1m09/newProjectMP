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



    @GetMapping("/product/save")
    public String productSave(Model model) {
        model.addAttribute("product",new Product());
        return "productSave";
    }

    @PostMapping("/product/save")
    public String createProduct(Model model,@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        model.addAttribute("product",product);
        return "redirect:/product";
    }


    @GetMapping("/product")
    public String product(Model model) {
        List <Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product";
    }


    @RequestMapping( value = "/product/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String deleteBook(@PathVariable(value = "id") Long id){
        productService.deleteProductById(id);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String productUpdateGet(Model model,@PathVariable(value = "id") Long id) {
       Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "productUpdate";
    }

    @PostMapping("/product/edit/{id}")
    public String updateProductPut(@PathVariable(value = "id") Long id, @ModelAttribute("product") Product product, Model model) {
        if (productService.findProductById(id)!=null) {
            productService.updateProduct(id, product);
            model.addAttribute("product", product);
            return  "redirect:/product";
        }
        model.addAttribute("product", product);
        return  "redirect:/product";
    }



    @RequestMapping ( value = "/product/addInBasket/{id}"  , method = { RequestMethod.GET, RequestMethod.POST })
    public String addProductInBasket (@PathVariable(value = "id") Long id, @RequestParam (value = "total" ) Integer total){
        Product product = productService.findProductById(id);
        basket.addProduct(product, total);

        return "redirect:/product";
    }
    }

