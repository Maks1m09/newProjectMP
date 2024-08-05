package by.marketplace.controller;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.entity.Product;
import by.marketplace.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    private final Basket basket;


    @GetMapping("/order")
    public String order(Model model) {
        List<Order> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "order";
    }


    @PostMapping("/basket/oder")
    public String createOrder(@RequestParam String phone, Model model) {
        Order order = new Order();
        order.setPhone(phone);
        order.setProducts(basket.getProducts());
        order.setOrderNumber((int) (Math.random() * 100));
        order.setPrize(orderService.buyProduct(basket));
        orderService.saveOrder(order);
        basket.clear();
        model.addAttribute("order", order);
        return "redirect:/order";
    }

}

