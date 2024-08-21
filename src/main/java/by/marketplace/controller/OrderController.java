package by.marketplace.controller;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;
import by.marketplace.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/basket/oder", method = {RequestMethod.GET, RequestMethod.POST})

    public String createOrder(@RequestParam(value = "phone") String phone, Model model) {
        Order order = orderService.saveOrder(phone);
        basket.clear();
        model.addAttribute("order", order);
        return "redirect:/order";
    }

}

