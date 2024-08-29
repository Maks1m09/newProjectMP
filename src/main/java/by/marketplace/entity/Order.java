package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private Date date = new Date();
    private Double price;
    private String phone;

    public Order(int number, Date date, Double price, String phone, Set<OrderProduct> orderProducts) {
        this.number = number;
        this.date = date;
        this.price = price;
        this.phone = phone;
        this.orderProducts = orderProducts;
    }

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    @ToString.Exclude
    private Set<OrderProduct> orderProducts = new HashSet<>();

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = new OrderProduct(this, product, quantity);
        orderProducts.add(orderProduct);
    }

    public void removeProduct(Product product) {
        orderProducts.removeIf(orderProduct -> orderProduct.getProduct().equals(product));
    }
}