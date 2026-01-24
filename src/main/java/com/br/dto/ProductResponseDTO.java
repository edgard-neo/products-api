package com.br.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductResponseDTO {

  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private Boolean active;
  private LocalDateTime createdAt;

  public ProductResponseDTO(
      Long id,
      String name,
      String description,
      BigDecimal price,
      Boolean active,
      LocalDateTime createdAt) {

    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.active = active;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
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

  public Boolean getActive() {
    return active;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
