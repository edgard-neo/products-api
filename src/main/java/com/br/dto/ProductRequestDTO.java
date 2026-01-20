package com.br.dto;

import java.math.BigDecimal;

public class ProductRequestDTO {

    private String name;

    private String description;

    private BigDecimal price;

    public ProductRequestDTO(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
