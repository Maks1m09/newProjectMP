package by.marketplace.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Data
@Component
public class Basket {


    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product, Integer total) {
        if (product.getQuantity() > 0 && total <= product.getQuantity()) {
            products.add(product);
            product.setQuantity(product.getQuantity() - total);
        } else {
            System.out.println("you can't buy that many books because there aren't that many books");

        }

    }
}
