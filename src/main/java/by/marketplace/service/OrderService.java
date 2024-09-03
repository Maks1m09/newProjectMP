package by.marketplace.service;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.entity.Product;
import by.marketplace.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final Basket basket;

    public Order saveOrder(String phone) {
        HashMap<Product, Integer> products = basket.getProducts();
        Order order = new Order();
        double sum = 0;
        order.setNumber(UUID.randomUUID().toString().replace("-", ""));
        order.setPhone(phone);
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Double key = entry.getKey().getPrice();
            Integer value = entry.getValue();
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            order.addProduct(product, quantity);
            sum += key * value;
        }
        order.setPrice(BigDecimal.valueOf(sum));
        orderRepository.save(order);
        log.info("Order saved");
        basket.clear();
        log.info("basket clear");
        return order;
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }
}


