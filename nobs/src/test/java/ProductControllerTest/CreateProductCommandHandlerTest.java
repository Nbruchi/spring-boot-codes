package ProductControllerTest;

import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.NoBsSpringBootApplication;
import com.example.demo.Products.Model.Product;
import com.example.demo.Products.ProductRepository;
import com.example.demo.Products.commandHandlers.CreateProductCommandHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = NoBsSpringBootApplication.class)
public class CreateProductCommandHandlerTest {
    @InjectMocks private CreateProductCommandHandler createProductCommandHandler;
    @Mock private ProductRepository productRepository;

    // MethodName_StateUnderTest_ExpectedBehaviour
    @Test
    public void createProductCommandHandler_validProduct_returnSuccess(){
        // Given,when,then
        //Arrange,act,assert

        //Given | Arrange
        Product product = new Product();
        product.setId(1);
        product.setPrice(9.99);
        product.setName("Best Chocolate");
        product.setDescription("Silky Dark");
        product.setQuantity(10);

        // When | Act
        ResponseEntity response = createProductCommandHandler.execute(product);

        // Then | Assert
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void createProductCommandHandler_invalidPrice_throwsInvalidPriceException(){
        // Given | Arrange
        Product product = new Product();
        product.setId(1);
        product.setPrice(-9.99);
        product.setName("Best Chocolate");
        product.setDescription("Silky Dark");
        product.setQuantity(10);

        // When/Then| Act
        ProductNotValidException exception =
                assertThrows(ProductNotValidException.class,() -> createProductCommandHandler.execute(product));

        // Then2 | Assert
        assertEquals("Product price cannot be negative!",exception.getSimpleResponse().getMessage());
    }
}
