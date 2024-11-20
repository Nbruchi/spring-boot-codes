package com.example.demo.Header;

import com.example.demo.Products.Model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {
    @GetMapping(value = "/header",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setName("myProduct");
        product.setId(1);
        product.setDescription("Greatest product ever");

        return ResponseEntity.ok(product);
    }
//    @GetMapping("/header")
//    public String getRegionHeader(@RequestHeader(required = false, defaultValue = "Rwanda") String region){
//        if(region.equals("Rwanda")) return  "BLACK EAGLE FREEDOM";
//        if(region.equals("CAN")) return "I bleed maple syrup";
//
//        return "Country not supported :)";
//    }
}