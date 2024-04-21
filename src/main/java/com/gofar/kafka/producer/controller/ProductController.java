package com.gofar.kafka.producer.controller;

import com.gofar.kafka.dto.ProductDto;
import com.gofar.kafka.producer.service.ProducerService;
import com.gofar.kafka.producer.model.Product;
import com.gofar.kafka.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
        producerService.publishProductData(Mapper.productDtoToProduct(productDto));
        return ResponseEntity.ok("Product saved successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        Product product = Mapper.productDtoToProduct(productDto);
        product.setId(id);
        producerService.publishProductData(product);
        return ResponseEntity.ok("Product updated successfully");
    }
}
