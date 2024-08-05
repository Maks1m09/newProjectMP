package by.marketplace.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@SessionScope
@Data
@Component
public class Basket {


    private List<Product> products = new LinkedList<>();

    public void addProduct(Product product, Integer total) {
        if (product.getQuantity() > 0 && total <= product.getQuantity()) {
            products.add(product);
            product.setQuantity(product.getQuantity() - total);
        } else {
            System.out.println("you can't buy that many books because there aren't that many books");

        }

    }

    public void clear (){
        products.clear();
    }
}

