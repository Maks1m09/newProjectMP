package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    private int orderNumber;


//    @ManyToMany
//    @BatchSize(size = 10)
//    @JoinTable(
//            name = "order_product",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List <Product> products = new ArrayList<>();



//    @ManyToOne
//    @JoinColumn(name = "basket_id", nullable = false)
//    private Basket basket;


}
