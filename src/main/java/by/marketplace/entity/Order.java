package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private String number;
    private LocalDate date = LocalDate.now();
    private BigDecimal price;
    private String phone;
    @OneToMany(mappedBy = "order", orphanRemoval = true)
    @ToString.Exclude
    private Set<OrderProduct> orderProducts = new HashSet<>();

    public Order(String number, LocalDate date, BigDecimal price, String phone, Set<OrderProduct> orderProducts) {
        this.number = number;
        this.date = date;
        this.price = price;
        this.phone = phone;
        this.orderProducts = orderProducts;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = new OrderProduct(this, product, quantity);
        orderProducts.add(orderProduct);
    }

    public void removeProduct(Product product) {
        orderProducts.removeIf(orderProduct -> orderProduct.getProduct().equals(product));
    }

}