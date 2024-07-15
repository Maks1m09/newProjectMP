package by.marketplace.repository;

import by.marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save (Product product);
    Product findById (Long id );
    ArrayList <Product> findAll ();
    void deleteById (Long id);
    void createByName (String name);
    Product findByName (String name);
}
