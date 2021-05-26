package br.com.rd.mscliente.domain.dto;

import br.com.rd.mscliente.infrastructure.persistence.product.Product;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
@Builder
public class ProductRequest {

    private final String name;
    private final BigDecimal price;

    public static Product toModel(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.name)
                .price(productRequest.price)
                .build();
    }
}
