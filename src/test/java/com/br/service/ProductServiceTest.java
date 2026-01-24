package com.br.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.br.domain.Product;
import com.br.exception.BusinessException;
import com.br.exception.ResourceNotFoundException;
import com.br.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductService - Testes Unitarios")
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private Product product;

    @BeforeEach
    void setUp() {

        product = new Product("Mouse Gamer", "RGB", new BigDecimal(150.00));
        product.setActive(true);

    }

    @Test
    @DisplayName("Deve criar o produto com sucesso")
    void deveCriarProdutoComSucesso() {

        when(repository.save(any(Product.class))).thenReturn(product);

        Product result = service.create(product);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Mouse Gamer");
        assertThat(result.getPrice()).isEqualTo(new BigDecimal(150.00));

        verify(repository, times(1)).existsByName("Mouse Gamer");
        verify(repository, times(1)).save(product);
    }

    @Test
    @DisplayName("Não deve criar produto com nome duplicado")
    void naoDeveCriarProdutoComNomeDuplicado() {

        when(repository.existsByName("Mouse Gamer")).thenReturn(true);

        assertThatThrownBy(() -> service.create(product)).isInstanceOf(BusinessException.class)
                .hasMessage("Produto já existe");

        verify(repository, times(1)).existsByName("Mouse Gamer");
        verify(repository, never()).save(any());
    }

    @Test
    @DisplayName("Deve buscar produto pelo ID com sucesso")
    void deveBuscarProdutoPorIdComSucesso() {

        when(repository.findById(1L)).thenReturn(Optional.of(product));

        Product result = service.findById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Mouse Gamer");

        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção quando produto não existe")
    void deveLancarExcecaoQuandoProdutoNaoExiste() {

        when(repository.findById(888L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.findById(888L))
                .isInstanceOf(ResourceNotFoundException.class).hasMessage("Produto não encontrado");

        verify(repository, times(1)).findById(888L);
    }

    // TODO: TERMINAR O RESTANTE DOS TESTES 24/01/26
}
