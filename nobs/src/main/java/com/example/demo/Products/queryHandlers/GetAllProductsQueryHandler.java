package com.example.demo.Products.queryHandlers;

import com.example.demo.Products.Model.ProductDTO;
import com.example.demo.Products.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<ProductDTO> productDTOS = productRepository.getAllProductDTOs();
        return ResponseEntity.ok(productDTOS);
    }
}
