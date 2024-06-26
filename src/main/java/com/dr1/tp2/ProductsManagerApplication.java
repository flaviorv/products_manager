package com.dr1.tp2;

import com.dr1.tp2.model.domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsManagerApplication.class, args);
        System.out.println("Application started");
    }

}
