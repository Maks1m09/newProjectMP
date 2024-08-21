package by.marketplace.service;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {


    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        if (product.getId() != null) {
            System.out.println("You cant save new product, because we have this product in DB");
        }
        productRepository.save(product);
        return product;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        System.out.println("We dont have Product with this id");
        return productRepository.findById(id).get();
    }

    public void updateProduct(Long id, Product product) {

        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrize(product.getPrize());
        existingProduct.setDescription(product.getDescription());
        productRepository.save(existingProduct);
    }

    public void deleteProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
        System.out.println("We cant delete because we dont have product with this id in DB ");
    }

}
