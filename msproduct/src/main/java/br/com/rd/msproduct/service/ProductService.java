package br.com.rd.mscliente.service;


import br.com.rd.mscliente.domain.dto.ProductRequest;
import br.com.rd.mscliente.domain.dto.ProductResponse;
import br.com.rd.mscliente.exception.ResourceNotFoundException;
import br.com.rd.mscliente.infrastructure.persistence.product.Product;
import br.com.rd.mscliente.infrastructure.persistence.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse saveOrUpdate(ProductRequest productRequest, Long id) {

        Product product;

        if (id == null) {
            product = ProductRequest.toModel(productRequest);
            return ProductResponse.fromModel(this.productRepository.save(product));
        }

        product = ProductRequest.toModel(productRequest);
        product.setId(id);

        return ProductResponse.fromModel(this.productRepository.save(product));
    }

    public ProductResponse findById(Long id) {

        return ProductResponse.fromModel(this.productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto", id)));
    }

    public Page<ProductResponse> findAll(Pageable pageable) {
        return ProductResponse.fromModels(this.productRepository.findAll(pageable));
    }

    public void delete(Long id) {
        Product product = this.productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto", id));
        this.productRepository.delete(product);
    }
}
