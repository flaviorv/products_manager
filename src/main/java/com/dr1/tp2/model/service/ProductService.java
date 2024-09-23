package com.dr1.tp2.model.service;

import com.dr1.tp2.model.domain.Product;
import com.dr1.tp2.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Mono<Product> register(Product product) {
        return productRepository.save(product);
    }

    public Flux<Product> getAll() {
        return productRepository.findAll();
    }

    public Mono<Product> getById(int id) {

        return productRepository.findById(id);

    }

    public Mono<Product> update(int id, Product product) throws Exception {
        product.setId(id);
        return productRepository.save(product);
    }

    public Mono<Void> deleteById(int id) {
        return productRepository.deleteById(id);
    }
}
