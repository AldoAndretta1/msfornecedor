package br.com.rd.mscliente.domain.dto;

import br.com.rd.mscliente.infrastructure.persistence.product.Product;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class ProductRequest {

    private final Long id;
    private final String name;
    private final BigDecimal price;

    public static Product toModel(ProductRequest productRequest) {
        return Product.builder()
                .id(productRequest.id)
                .name(productRequest.name)
                .price(productRequest.price)
                .build();
    }
}
