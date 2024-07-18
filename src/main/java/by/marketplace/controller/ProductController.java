package by.marketplace.controller;

import by.marketplace.entity.Product;
import by.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;


    @PostMapping("/product/save")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productService.findAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable(value = "id") long id) {
        productService.deleteProductById(id);

    }

    @PutMapping("/edit/{id}")
    public Product updateBook(@PathVariable(value = "id") long id, @RequestBody Product product) {
        if (productService.findProductById(id).isPresent()) {
            productService.updateProduct(id, product);
            return product;
        }
        return product;
    }
}