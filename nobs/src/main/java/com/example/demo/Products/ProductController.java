package com.example.demo.Products;

import com.example.demo.Products.Model.Product;
import com.example.demo.Products.Model.ProductDTO;
import com.example.demo.Products.Model.UpdateProductCommand;
import com.example.demo.Products.commandHandlers.CreateProductCommandHandler;
import com.example.demo.Products.commandHandlers.DeleteProductCommandHandler;
import com.example.demo.Products.commandHandlers.UpdateProductCommandHandler;
import com.example.demo.Products.queryHandlers.GetAllProductsQueryHandler;
import com.example.demo.Products.queryHandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired private ProductRepository productRepository;
    @Autowired private GetAllProductsQueryHandler getAllProductsQueryHandler;
    @Autowired private GetProductQueryHandler getProductQueryHandler;
    @Autowired private CreateProductCommandHandler createProductCommandHandler;
    @Autowired private UpdateProductCommandHandler updateProductCommandHandler;
    @Autowired private DeleteProductCommandHandler deleteProductCommandHandler;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return getAllProductsQueryHandler.execute(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id){
        return getProductQueryHandler.execute(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(value = "description") String description){
        return ResponseEntity.ok(productRepository.findByDescriptionContaining(description));
    }
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        return createProductCommandHandler.execute(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id,@RequestBody Product product){
        UpdateProductCommand command = new UpdateProductCommand(id,product);
        return updateProductCommandHandler.execute(command);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        return deleteProductCommandHandler.execute(id);
    }
}
