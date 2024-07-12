package by.marketplace;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import by.marketplace.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.awaitility.Awaitility.given;
<<<<<<< HEAD
import static org.mockito.Mockito.*;
=======
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
>>>>>>> origin/Test

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

<<<<<<< HEAD
    @Mock
    private ProductRepository
    productRepository;

    @InjectMocks
=======
//    @Mock
//    private ProductRepository
//    productRepository;

    @Mock
>>>>>>> origin/Test
    private ProductService
    productService;

    @Test
    public void whenSaveProduct_ShouldReturnProduct(){
<<<<<<< HEAD
        Product product = mock(Product.class);
=======
        Product product = new Product();
>>>>>>> origin/Test
        product.setId(1L);
        product.setName("TestProduct");
        product.setPrize(1200);
        product.setQuantity(20);
        product.setDescription("New product");

<<<<<<< HEAD
        doNothing().when(productService).saveProduct(product);
        verify(productService,times(1)).saveProduct(product);

=======
        productService.saveProduct(product);
        verify(productService.saveProduct(product);
>>>>>>> origin/Test
    }
}
