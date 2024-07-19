package by.marketplace;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import by.marketplace.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class ProductServiceTest {

    private final ProductRepository repository = mock();
    private final ProductService service  = new ProductService(repository);

    @Test
    public void testN (){
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Pety");
        Assert.assertEquals("Pety", product.getName());

    }
    @Test
    public void testMethodSaveProduct (){
        Product product = mock(Product.class);
        when(service.saveProduct(product).getName()).thenReturn("Pety");
        Assert.assertEquals("Pety",product.getName());
        verify (repository, times(1)) .save(product);
    }

    @Test
    public void testMethodDeleteProduct (){
        Product product = mock(Product.class);
        service.saveProduct(product);
        doNothing().when(repository).deleteById(isA(Long.class));
      //  verify(repository,times(1)).deleteById(0L);
    }
}
