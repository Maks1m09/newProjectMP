package by.marketplace;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import by.marketplace.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.verify;




public class ProductServiceTest {

    private final ProductRepository repository = mock();
    private final ProductService service  = new ProductService(repository);

    @Test
    public void testN (){
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Pety");
        Assert.assertEquals("Pety", product.getName());

    }




}
