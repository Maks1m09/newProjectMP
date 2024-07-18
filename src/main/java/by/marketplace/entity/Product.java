package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_product")
    private String name;
    @Column(name = "quantity_product")
    private int quantity;
    @Column(name = "prize_product")
    private double prize;
    @Column(name = "description")
    private String description;
}
