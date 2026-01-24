package com.br.repository;

import com.br.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByActiveTrue();

  Optional<Product> findByIdAndActiveTrue(Long id);

  boolean existsByName(String name);
}
