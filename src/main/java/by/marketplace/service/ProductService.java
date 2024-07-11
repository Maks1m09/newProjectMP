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
         if (productRepository.findById(product.getId()).isPresent()){
             System.out.println("You cant save new product, because we have this product in DB");
         }
       productRepository.save(product);
     }

     public ArrayList <Product> findAllProducts (){
        return productRepository.findAll();
     }


     public void  findProductById (Long id){
         if (productRepository.findById(id).isPresent()){
             productRepository.findById(id);
         }
         System.out.println("We dont have Product with this id");
     }

     public void createProduct (String name){
        Product product = productRepository.findByName (name);
         if (product!=null){
             productRepository.createByName(name);
         }
         System.out.println("We dont have Product with this name in DB");
     }

//     public void deleteProductById (Long id){
//         Product product = productRepository.findById(id).;
//         productRepository.deleteById(id);
//     }



}
