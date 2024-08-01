package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
    private Integer quantity;
    @Column(name = "prize_product")
    private Double prize;
    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", prize=" + prize +
                ", description='" + description + '\'' +
                '}';
    }

//    @ManyToMany
//    @BatchSize(size = 10)
//    @JoinTable(
//            name = "order_product",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders = new ArrayList<>();



}
