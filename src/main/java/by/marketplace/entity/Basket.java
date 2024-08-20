package by.marketplace.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


@SessionScope
@Data
@Component
public class Basket {

    private HashMap <Product, Integer > products = new HashMap();


    public void addProduct(Product product, Integer total) {


        if (product.getQuantity() > 0 && total <= product.getQuantity()) {
            products.put(product, total);
            product.setQuantity(product.getQuantity() - total);
        } else {
            System.out.println("you can't buy that many books because there aren't that many books");
        }
    }

    public void clear() {
        products.clear();
    }
}

