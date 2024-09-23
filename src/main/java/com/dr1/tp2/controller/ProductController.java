package com.dr1.tp2.controller;

import com.dr1.tp2.model.domain.Product;
import com.dr1.tp2.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
    Flux<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    Mono<Product> getById(@PathVariable int id) {
        return productService.getById(id);
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
