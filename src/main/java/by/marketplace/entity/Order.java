package by.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderNumber")
    private int orderNumber;

    @Column(name = "date")
    private Date date = new Date();

    @Column(name = "prize")
    private Double prize;

    @Column(name = "phone")
    private String phone;

    @ManyToMany (mappedBy = "orders")
    @BatchSize(size = 10)
    private List<Product> products = new ArrayList<>();

}
