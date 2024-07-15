package by.marketplace.service;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

     public void saveProduct (Product product){
         if (productRepository.findById(product.getId())!=null){
             System.out.println("You cant save new product, because we have this product in DB");
         }
       productRepository.save(product);
     }

     public ArrayList <Product> findAllProducts (){
        return productRepository.findAll();
     }


     public Optional<Product> findProductById (Long id){
         if (productRepository.findById(id)!=null){
             Product product = productRepository.findById(id);
             return Optional.ofNullable(product);
         }
         System.out.println("We dont have Product with this id");
         return Optional.empty();
     }


     public void createProduct (String name){
        Product product = productRepository.findByName (name);
         if (product!=null){
             productRepository.createByName(name);
         }
         System.out.println("We dont have Product with this name in DB");
     }

     public void deleteProductById (Long id){
         if (productRepository.findById(id)!=null){
             productRepository.deleteById(id);
         }
         System.out.println("We cant delete because we dont have product with this id in DB ");
     }



}
