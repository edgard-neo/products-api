package com.br.mapper;

import com.br.domain.Product;
import com.br.dto.ProductRequestDTO;
import com.br.dto.ProductResponseDTO;

public class ProductMapper {

  private ProductMapper() {} // impede new ProductMapper()

  public static Product toEntity(ProductRequestDTO request) {

    return new Product(request.getName(), request.getDescription(), request.getPrice());
  }

  public static ProductResponseDTO toResponse(Product response) {

    return new ProductResponseDTO(
        response.getId(),
        response.getName(),
        response.getDescription(),
        response.getPrice(),
        response.getActive(),
        response.getCreatedAt());
  }
}
