package by.marketplace.entity;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;

@SessionScope
@Data
@Component
public class Basket {

    private HashMap<Product, Integer> products = new HashMap();

    private static final Logger logger = LogManager.getLogger(Basket.class);

    public void addProduct(Product product, Integer total) {
        if (product.getQuantity() > 0 && total <= product.getQuantity()) {
            products.put(product, total);
            product.setQuantity(product.getQuantity() - total);
        } else {
            logger.info("you can't buy that many products because there aren't that many products");
        }
    }

    public void clear() {
        products.clear();
    }
}

