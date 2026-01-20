package com.br.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.br.domain.Product;
import com.br.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {

        if (repository.existsByName(product.getName())) {

            throw new IllegalArgumentException("Produto já existe");
        }

        return repository.save(product);
    }

    public List<Product> listActive() {

        return repository.findByActiveTrue();
    }

    public Product findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

    }

    public Product update(Long id, Product update) {

        Product product = this.findById(id);

        product.setName(update.getName());
        product.setDescription(update.getDescription());
        product.setPrice(update.getPrice());

        return repository.save(product);

    }

    public void delete(Long id) {

        Product product = this.findById(id);

        product.setActive(false);

        repository.save(product);

    }
}
