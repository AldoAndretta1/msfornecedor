package br.com.rd.mscliente.service;


import br.com.rd.mscliente.domain.dto.ProductRequest;
import br.com.rd.mscliente.domain.dto.ProductResponse;
import br.com.rd.mscliente.exception.ResourceNotFoundException;
import br.com.rd.mscliente.infrastructure.persistence.product.Product;
import br.com.rd.mscliente.infrastructure.persistence.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse save(ProductRequest productRequest) {

        Product product = this.productRepository.save(ProductRequest.toModel(productRequest));

        return ProductResponse.fromModel(product);
    }

    public ProductResponse findById(Long id) {

        return ProductResponse.fromModel(this.productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto", id)));
    }
}
