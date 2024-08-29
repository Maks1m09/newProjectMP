package by.marketplace.service;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    public Product saveProduct(Product product) {
        if (product.getId() != null) {
            logger.info("You can't save new product, because we have this product in your DB");
        }
        productRepository.save(product);
        logger.info("Product saved in DB");
        return product;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        logger.debug("We don't have Product with this id");
        return productRepository.findById(id).get();
    }

    public void updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        productRepository.save(existingProduct);
        logger.info("Product updated and saved");
    }

    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            logger.info("Product with" + " " + id + " deleted");
            logger.debug("Product with" + " " + id + " deleted");
        }
        logger.info("We can't delete because we don't have product with this id in our DB");
    }
}
