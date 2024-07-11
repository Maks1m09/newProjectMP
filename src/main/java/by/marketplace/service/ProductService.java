package by.marketplace.service;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

     public void saveProduct (Product product){

     };

     public void findProductById (Long id);

     public void  findAllProduct ();

     public void createProduct ();

     public void deleteProduct ();



}
