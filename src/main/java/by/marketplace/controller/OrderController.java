package by.marketplace.controller;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Order;

import by.marketplace.entity.Product;
import by.marketplace.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping( value = "/basket/oder" , method = { RequestMethod.GET, RequestMethod.POST })

        public String createOrder (@RequestParam (value = "phone") String phone, Model model){
        Order order = orderService.saveOrder(phone);
        basket.clear();
        model.addAttribute("order", order);
        return "redirect:/order";
    }

}

