//package by.marketplace.controller;
//
//import by.marketplace.entity.Product;
//import by.marketplace.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//public class ProductController {
//
//    private final ProductService productService;
//
//    @PostMapping("/api/product/save")
//    public Product createProduct(@RequestBody Product product) {
//        return productService.saveProduct(product);
//    }
//
//    @GetMapping("/api/product")
//    public List<Product> getAllProduct() {
//        return productService.findAllProducts();
//    }
//
//    @DeleteMapping("/api/product/delete/{id}")
//    public void deleteProduct(@PathVariable(value = "id") long id) {
//        productService.deleteProductById(id);
//    }
//
//    @PutMapping("/api/product/edit/{id}")
//    public Product updateProduct(@PathVariable(value = "id") long id, @RequestBody Product product) {
//        if (productService.findProductById(id) != null) {
//            productService.updateProduct(id, product);
//            return product;
//        }
//        return product;
//    }
//}