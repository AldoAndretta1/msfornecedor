package br.com.rd.mscliente.domain.dto;

import br.com.rd.mscliente.infrastructure.persistence.product.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.util.stream.Collectors;

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

    public static Page<ProductResponse> fromModels(Page<Product> productPage) {
        return new PageImpl<>(
                productPage.stream().map(product -> ProductResponse.fromModel(product)).collect(Collectors.toList())
        );
    }

}
