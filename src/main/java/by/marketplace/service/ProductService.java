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
}
