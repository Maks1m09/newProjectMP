package by.marketplace.service;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.entity.Product;
import by.marketplace.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

//     for(
//    Map.Entry<Product, Integer> entry : hashMap.entrySet()) {
//
//        Integer key = entry.getKey().getPrize();
//        Integer value = entry.getValue();
//        sum+=key*value;
//    }

    public Double buyProduct (Basket basket){
        double sum = 0;
        if(basket.getProducts().size()>0){
            HashMap<Product, Integer> products = basket.getProducts();
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                Double key = entry.getKey().getPrize();
                Integer value = entry.getValue();
                sum+=key*value;
            }
        }
        return sum;
    }
}
