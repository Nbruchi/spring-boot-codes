package ProductControllerTest;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.NoBsSpringBootApplication;
import com.example.demo.Products.Model.Product;
import com.example.demo.Products.Model.ProductDTO;
import com.example.demo.Products.ProductRepository;
import com.example.demo.Products.queryHandlers.GetProductQueryHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = NoBsSpringBootApplication.class)
public class GetProductQueryHandlerTest {
    @InjectMocks private GetProductQueryHandler getProductQueryHandler;
    @Mock private ProductRepository productRepository;

    @Test
    public void getProductQueryHandler_validId_returnsProductDTO(){
        //Given
        Product product = new Product();
        product.setId(1);
        product.setPrice(9.99);
        product.setName("Chocolate");
        product.setDescription("Silky dark");
        product.setQuantity(10);

        ProductDTO expectedDTO = new ProductDTO(product);

        // And
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        // When
        ResponseEntity<ProductDTO> actualResponse = getProductQueryHandler.execute(product.getId());

        // Then
        assertEquals(expectedDTO,actualResponse.getBody());
        assertEquals(HttpStatus.OK,actualResponse.getStatusCode());
    }

    @Test
    public void getProductQueryHandler_invalidId_throwsProductNotFoundException(){
        // Given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // When/Then
        ProductNotFoundException exception =
                assertThrows(ProductNotFoundException.class, () -> getProductQueryHandler.execute(1));

        // Then 2
        assertEquals("Product not found!",exception.getSimpleResponse().getMessage());
    }
}
