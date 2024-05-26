package com.dr1.tp2.controller;

import com.dr1.tp2.model.domain.Product;
import com.dr1.tp2.service.ProductService;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ParameterNamesModule parameterNamesModule;

    @PostMapping
    ResponseEntity register(@RequestBody Product product) {
        try {
            productService.register(product);
            return ResponseEntity.ok(product);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(productService.getAll());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable int id) {
        try {
            Optional<Product> p = productService.getById(id);
            return ResponseEntity.ok(p);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable int id, @RequestBody Product product) throws Exception {
        try{
            productService.update(id, product);
            return ResponseEntity.ok(product);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteById(@PathVariable int id) {
        try {
            Product product = productService.deleteById(id);
            Map<String, String> message = Map.of("deletedProduct", product.getName());
            return ResponseEntity.ok(message);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
