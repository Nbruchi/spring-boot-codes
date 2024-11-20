package com.example.demo.Products;

import com.example.demo.Products.Model.Product;
import com.example.demo.Products.Model.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //Query to write our own SQL statement
    @Query("SELECT p FROM Product p WHERE p.description LIKE %:description%")
    List<Product> customQueryMethod(@Param(value = "description") String description);

    @Query("SELECT p.name, p.description,p.price FROM Product p")
    List<ProductDTO> getAllProductDTOs();

    // Spring Data JPA to have Spring generate it for us
    List<Product> findByDescriptionContaining(String keyword);
}
