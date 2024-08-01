package by.marketplace.service;

import by.marketplace.entity.Basket;
import by.marketplace.entity.Product;
import by.marketplace.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class OrderService {

  private final   OrderRepository orderRepository;
//    public List<Product> addProductInBasket (Basket basket, Product product, int total){
//        List <Product>products = basket.getProducts();
//        if (product.getQuantity()>0 && total<=product.getQuantity()){
//            products.add(product);
//            product.setQuantity(product.getQuantity()-total);
//        } else {
//            System.out.println("you can't buy that many books because there aren't that many books");
//        }
//        basketRepository.save(basket);
//        return basket.getProducts();
//    }
//
//
//
//    public Double buyProduct (Basket basket){
//        double sum = 0;
//        if(basket.getProducts().size()>0){
//            List<Product> products = basket.getProducts();
//            for (Product value : products) {
//                sum = (value.getPrize() * value.getQuantity()) + sum;
//            }
//        }
//        basket.setPrice(sum);
//        basketRepository.save(basket);
//        return sum;
//    }
}
