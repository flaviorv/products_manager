package com.dr1.tp2.model.repository;

import com.dr1.tp2.model.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}