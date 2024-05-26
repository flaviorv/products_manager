package com.dr1.tp2.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.runtime.internal.Conversions;

import java.nio.ByteBuffer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    private String name;
    private int centsPrice;

    public String getPriceInReais(){
        Float fPrice = centsPrice / 100f;
        String strPrice = String.format("%.2f", fPrice);
        strPrice = strPrice.replace(".", ",");
        return "R$ "+ strPrice;
    }
}
