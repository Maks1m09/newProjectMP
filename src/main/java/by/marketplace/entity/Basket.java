package by.marketplace.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;

@Slf4j
@SessionScope
@Data
@Component
public class Basket {

    private HashMap<Product, Integer> products = new HashMap();

    public void addProduct(Product product, Integer total) {
        if (product.getQuantity() > 0 && total <= product.getQuantity()) {
            log.info("byy: " + product.getName() + "/ quantity: " + total + " / allQuantity: " + product.getQuantity());
            products.put(product, total);
            product.setQuantity(product.getQuantity() - total);
        } else {
            log.info("you can't buy " + product.getName() + " that many products " + product.getQuantity()
                    + " because there aren't that many products");
        }
    }

    public void clear() {
        products.clear();
    }
}

