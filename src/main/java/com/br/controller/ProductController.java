package com.br.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.domain.Product;
import com.br.dto.ProductRequestDTO;
import com.br.dto.ProductResponseDTO;
import com.br.mapper.ProductMapper;
import com.br.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @Valid @RequestBody ProductRequestDTO request) {

        Product product = service.create(ProductMapper.toEntity(request));

        ProductResponseDTO response = ProductMapper.toResponse(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {

        Product product = service.findById(id);

        ProductResponseDTO response = ProductMapper.toResponse(product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> listActive() {

        List<ProductResponseDTO> response =
                service.listActive().stream().map(ProductMapper::toResponse).toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {

        Product req = ProductMapper.toEntity(request);
        Product product = service.update(id, req);

        ProductResponseDTO response = ProductMapper.toResponse(product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
