package by.marketplace.service;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.entity.Product;
import by.marketplace.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final Basket basket;

    public Order saveOrder(String phone) {
        HashMap<Product, Integer> products = basket.getProducts();
        Order order = new Order();
        order.setOrderNumber((int) (Math.random() * 100));
        order.setPhone(phone);
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            order.addProduct(product, quantity);
        }
        order.setPrize(buyProduct(basket));
        orderRepository.save(order);
        return order;
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }


    public Double buyProduct(@NotNull Basket basket) {
        double sum = 0;
        if (basket.getProducts().size() > 0) {
            HashMap<Product, Integer> products = basket.getProducts();
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                Double key = entry.getKey().getPrize();
                Integer value = entry.getValue();
                sum += key * value;
            }
        }
        return sum;
    }
}
