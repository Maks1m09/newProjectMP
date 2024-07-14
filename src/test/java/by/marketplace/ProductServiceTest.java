package by.marketplace;

import by.marketplace.entity.Product;
import by.marketplace.repository.ProductRepository;
import by.marketplace.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.verify;



@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {


    @Mock
    private ProductRepository


@InjectMocks

    private ProductService
    productService;

    @Test
    public void whenSaveProduct_ShouldReturnProduct(){

        Product product = mock(Product.class);;

        product.setId(1L);
        product.setName("TestProduct");
        product.setPrize(1200);
        product.setQuantity(20);
        product.setDescription("New product");

        doNothing().when(productService).saveProduct(product);
        verify(productService,times(1)).saveProduct(product);


    }
}
