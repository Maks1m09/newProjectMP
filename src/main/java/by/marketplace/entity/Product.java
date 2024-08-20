package by.marketplace.entity;

import jakarta.persistence.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
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

    public Product() {
    }

    public Product(String name, Integer quantity, Double prize, String description) {
        this.name = name;
        this.quantity = quantity;
        this.prize = prize;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
