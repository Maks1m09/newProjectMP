package by.marketplace.service;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        log.debug("We don't have Product with this id " + id);
        return productRepository.findById(id).get();
    }

    public Product saveProduct(Product product) {
        if (product.getId() != null) {
            log.info("You can't save new product " + product.getName() + ", because we have this product in your DB");
        }
        productRepository.save(product);
        log.info("Product " + product.getName() + " saved in DB");
        return product;
    }

    public void updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        productRepository.save(existingProduct);
        log.info("Product " + product.getName() + " updated and saved");
    }

    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            log.info("Product with" + " " + id + " deleted");
        }
        log.info("We can't delete because we don't have product with this id in our DB");
    }
}
