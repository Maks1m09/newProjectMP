package by.marketplace;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import by.marketplace.service.ProductService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ProductServiceTest {

    private final ProductRepository repository = mock();
    private final ProductService service  = new ProductService(repository);

    @Test
    public void testN (){
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Pety");
        assertEquals("Pety", product.getName());

    }
    @Test
    public void testMethodSaveProduct (){
        Product product = mock(Product.class);
        when(repository.save(product)).thenReturn(product);
       assertEquals(service.saveProduct(product), product);
//        verify (repository, times(1)) .save(product);
    }

    @Test
    public void testMethodDeleteProduct (){
        doNothing().when(repository).deleteById(any());
        service.deleteProductById(1L);
       verify(repository,times(1)).deleteById(1L);
    }
}
