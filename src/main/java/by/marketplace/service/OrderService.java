package by.marketplace.service;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.entity.Product;
import by.marketplace.entity.Status;
import by.marketplace.repository.OrderRepository;
import by.marketplace.repository.ProductRepository;
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

    private final ProductRepository productRepository;

    public Order saveOrder(String phone) {
        HashMap<Product, Integer> products = basket.getProducts();
        Order order = new Order();
        order.setNumber(UUID.randomUUID().toString().replace("-", ""));
        order.setPhone(phone);
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            order.addProduct(product, quantity);
            sum += product.getPrice().doubleValue() * quantity;
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
        }
        order.setPrice(BigDecimal.valueOf(sum));
        order.setStatus(Status.PEDNING);
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


