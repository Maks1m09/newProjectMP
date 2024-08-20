package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
//@AllArgsConstructor
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

//    @Column(name = "nameUser")
//    private String nameUser;

//    public Order() {
//    }

    public Order(int orderNumber, Date date, Double prize, String phone,  Set<OrderProduct> orderProducts) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.prize = prize;
        this.phone = phone;

        this.orderProducts = orderProducts;
    }

    @OneToMany(mappedBy = "order",  orphanRemoval = true)
    @ToString.Exclude
    private Set<OrderProduct> orderProducts = new HashSet<>();


    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = new OrderProduct(this, product, quantity);
        orderProducts.add(orderProduct);
    }

    public void removeProduct(Product product) {
        orderProducts.removeIf(orderProduct -> orderProduct.getProduct().equals(product));
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Double getPrize() {
//        return prize;
//    }
//
//    public void setPrize(Double prize) {
//        this.prize = prize;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//
//    public Set<OrderProduct> getOrderProducts() {
//        return orderProducts;
//    }
//
//    public void setOrderProducts(Set<OrderProduct> orderProducts) {
//        this.orderProducts = orderProducts;
//    }

}