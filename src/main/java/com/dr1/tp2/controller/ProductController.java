package com.dr1.tp2.controller;

import com.dr1.tp2.model.domain.Product;
import com.dr1.tp2.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    Mono<Product> register(@RequestBody Product product) {
        return productService.register(product);

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
            Mono p = productService.getById(id);
            return ResponseEntity.ok(p);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    Mono<Product> update(@PathVariable int id, @RequestBody Product product) throws Exception {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteById(@PathVariable int id) {
        return productService.deleteById(id);
    }

}
