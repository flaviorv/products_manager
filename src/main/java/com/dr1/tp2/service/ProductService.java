package com.dr1.tp2.service;

import com.dr1.tp2.model.domain.Product;
import com.dr1.tp2.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product register(Product product) throws Exception {
        try {
           return productRepository.save(product);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Iterable<Product> getAll() throws Exception {
        try {
            return productRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Product> getById(int id) throws Exception {
        if(productRepository.existsById(id)) {
            return productRepository.findById(id);
        }
        throw new Exception("Id does not exist");
    }

    public Product update(int id, Product product) throws Exception {
        if(productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        throw new Exception("Id does not exist");
    }

    public Product deleteById(int id) throws Exception {
        if(productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            productRepository.deleteById(id);
            return product;
        }
        throw new Exception("Id does not exist");
    }
}
