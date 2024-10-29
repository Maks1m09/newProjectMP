package by.marketplace.service;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> {
                    log.debug("Product with id '{}' not found", id);
                    return new NoSuchElementException("Product not found for id: " + id);
                });
    }

    public Product saveProduct(Product product) {
        if (product.getId() != null) {
            log.info("Unable to save '{}': product with id '{}' already exists", product.getName(), product.getId());
            throw new IllegalArgumentException("Product id must be unique");
        }
        productRepository.save(product);
        log.info("Product '{}' saved", product.getName());
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
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            log.info("Product with id '{}' deleted", id);
        } else {
            log.info("Cannot delete because product with id '{}' does not exist", id);
        }
    }
}
