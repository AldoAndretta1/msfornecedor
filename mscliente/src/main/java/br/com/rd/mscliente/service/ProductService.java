package br.com.rd.mscliente.service;

import br.com.rd.mscliente.domain.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    public ProductResponse findById(Long id) {

        ProductResponse productResponse = new ProductResponse(id, "Teste", new BigDecimal(11.0));

        return productResponse;
    }
}
