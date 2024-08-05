package by.marketplace.service;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.entity.Product;
import by.marketplace.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class OrderService {

  private final   OrderRepository orderRepository;

    public Order saveOrder (Order order) {
        return order;
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    public Double buyProduct (Basket basket){

        double sum = 0;
        if(basket.getProducts().size()>0){
            List<Product> products = basket.getProducts();
            for (Product value : products) {
                sum = (value.getPrize() * value.getQuantity()) + sum;
            }
        }

        return sum;
    }
}
