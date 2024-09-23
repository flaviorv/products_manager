package com.dr1.tp2.model.repository;

import com.dr1.tp2.model.domain.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;


public interface ProductRepository extends R2dbcRepository<Product, Integer> {
}