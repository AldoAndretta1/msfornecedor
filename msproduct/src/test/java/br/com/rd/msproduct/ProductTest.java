package br.com.rd.msproduct;

import br.com.rd.msproduct.domain.dto.ProductRequest;
import br.com.rd.msproduct.domain.dto.ProductResponse;
import br.com.rd.msproduct.exception.ResourceNotFoundException;
import br.com.rd.msproduct.infrastructure.persistence.product.Product;
import br.com.rd.msproduct.infrastructure.persistence.product.ProductRepository;
import br.com.rd.msproduct.service.ProductService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    Long id = 1L;

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ResourceNotFoundException resourceNotFoundException;
    @Mock
    private Product product;

    private static final String MESSAGE_ID = "recurso %s com identificador %d não encontrado.";
    private static final String entityName = "Produto";

    @Test
    @DisplayName("Unit testing referring to get method. Successful call.")
    public void getMethodTest_WhenFindById_ExpectedProductResponse() {

        Product product = Product.builder()
                .id(this.id)
                .name("Product test")
                .price(new BigDecimal(10L)).build();

        Optional<Product> optionalProduct = Optional.of(product);

        when(this.productRepository.findById(any())).thenReturn(optionalProduct);

        var response = this.productService.findById(this.id);

        assertThat(response, CoreMatchers.isA(ProductResponse.class));

    }

    @Test
    @DisplayName("Unit testing referring to get method. Not Found Exception is thrown")
    public void getMethodTest_WhenFindById_ExpectedNotFoundException() {

        when(this.productRepository.findById(any())).thenThrow(new ResourceNotFoundException("Produto", this.id) {});

        try {
            this.productRepository.findById(this.id);
        } catch (ResourceNotFoundException e) {
            this.resourceNotFoundException = e;
        }

        assertThat(this.resourceNotFoundException, instanceOf(ResourceNotFoundException.class));
        assertEquals(this.resourceNotFoundException.getMessage(),String.format(this.MESSAGE_ID, this.entityName, this.id));
    }

    @Test
    @DisplayName("Unit testint referring to post method. Expect a product response.")
    public void postMethod_WhenSaveNewProduct_ExpectedProductResponse() {
        ProductRequest productRequest = ProductRequest.builder()
                .name("teste")
                .price(new BigDecimal(1L)).build();

        Product product = Product.builder()
                .id(this.id)
                .name("Product test")
                .price(new BigDecimal(10L)).build();

        when(this.productRepository.save(any())).thenReturn(product);
        var response = this.productService.saveOrUpdate(productRequest, null);

        assertThat(response, CoreMatchers.isA(ProductResponse.class));
    }

    @Test
    @DisplayName("Unit testing referring to put method. Expect a product response.")
    public void putMethod_WhenUpdateAProduct_ExpectedProductResponse() {
        ProductRequest productRequest = ProductRequest.builder().name("teste").price(new BigDecimal(1L)).build();
        Product product = Product.builder().id(1L).name("teste").price(new BigDecimal(1L)).build();

        when(this.productRepository.save(any())).thenReturn(product);

        var response = this.productService.saveOrUpdate(productRequest, this.id);

        assertThat(response, CoreMatchers.isA(ProductResponse.class));
    }

    @Test
    @DisplayName("Unit testing referring to delete method. Expect delete method to be called 1 time")
    public void deleteMethod_WhenDeleteAProduct_ExpectedDeleteMethodCalledOneTime() {
        Product productTest = Product.builder()
                .id(this.id)
                .name("Product test")
                .price(new BigDecimal(10L)).build();
        Optional<Product> optionalProduct = Optional.of(productTest);

        when(this.productRepository.findById(this.id)).thenReturn(optionalProduct);
        Mockito.doNothing().when(this.productRepository).delete(productTest);

        this.productService.delete(this.id);

        verify(this.productRepository, times(1)).delete(productTest);
    }

    @Test
    @DisplayName("Unit testing referring to delete method. Expect delete method to not be called")
    public void deleteMethod_WhenDeleteAProduct_ExpectedNotFoundException() {

        when(this.productRepository.findById(any())).thenThrow(new ResourceNotFoundException("Produto", this.id) {});

        ResourceNotFoundException exception = null;

        try {
            this.productService.delete(this.id);
        } catch (ResourceNotFoundException e) {
            exception = e;
        }
        assertThat(exception, instanceOf(ResourceNotFoundException.class));
        //assertThat(exception, is(nullValue()));
        assertEquals(exception.getMessage(),String.format(this.MESSAGE_ID, this.entityName, this.id));
    }
}
