package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;

@Data

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameProduct")
    private String name;
    @Column(name = "quantityProduct")
    private int quantity;
    @Column(name = "prizeProduct")
    private double prize;
    @Column(name = "description")
    private String description;
}
