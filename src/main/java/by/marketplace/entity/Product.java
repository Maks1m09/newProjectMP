package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product")
    private String name;

    @Column(name = "quantity_product")
    private Integer quantity;
    @Column(name = "prize_product")
    private Double prize;
    @Column(name = "description")
    private String description;


    public Product(String name, Integer quantity, Double prize, String description) {
        this.name = name;
        this.quantity = quantity;
        this.prize = prize;
        this.description = description;
    }

}
