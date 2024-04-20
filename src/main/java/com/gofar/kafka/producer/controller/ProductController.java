package com.gofar.kafka.producer.controller;

import com.gofar.kafka.dto.ProductDto;
import com.gofar.kafka.producer.ProducerService;
import com.gofar.kafka.producer.model.Product;
import com.gofar.kafka.utils.Mapper;
import com.gofar.kafka.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public ResponseEntity<Response> saveProduct(@RequestBody ProductDto productDto) {
        Response response = new Response();
        producerService.publishProductData(Mapper.productDtoToProduct(productDto));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        Product product = new Product();
        product.setId(5L);
        product.setName("Car");
        product.setQuantity(5);
        product.setReference("5ZTA333");
        producerService.publishProductData(product);
        return ResponseEntity.ok(response);
    }
}
