package br.com.rd.mscliente.domain.dto;

import br.com.rd.mscliente.infrastructure.persistence.product.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class ProductResponse {

    private final Long id;
    private final String name;
    private final BigDecimal price;

    public static ProductResponse fromModel(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
