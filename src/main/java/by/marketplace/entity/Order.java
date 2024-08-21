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

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "date")
    private Date date = new Date();

    @Column(name = "prize")
    private Double prize;

    @Column(name = "phone")
    private String phone;


    public Order(int orderNumber, Date date, Double prize, String phone, Set<OrderProduct> orderProducts) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.prize = prize;
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