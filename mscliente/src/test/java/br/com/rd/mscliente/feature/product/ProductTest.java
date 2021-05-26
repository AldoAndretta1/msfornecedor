package br.com.rd.mscliente.feature.product;

import br.com.rd.mscliente.domain.dto.ProductRequest;
import br.com.rd.mscliente.domain.dto.ProductResponse;
import br.com.rd.mscliente.exception.ResourceNotFoundException;
import br.com.rd.mscliente.service.ProductService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lombok.RequiredArgsConstructor;


import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RequiredArgsConstructor
public class ProductTest {

    private Long id;
    private ProductResponse productResponse;
    private ProductRequest productRequest;
    private String nomeProduto;
    private BigDecimal precoProduto;

    private final ProductService productService;
    private ResourceNotFoundException resourceNotFoundException;
    private static final String MESSAGE_ID = "recurso %s com identificador %d não encontrado.";
    private static final String entityName = "Produto";

    @Given("tenho um produto")
    public void tenhoUmProduto() {
        this.precoProduto = new BigDecimal(11L);
        this.nomeProduto = "nome";
        this.productRequest = ProductRequest.builder()
            .name(this.nomeProduto)
            .price(this.precoProduto)
            .build();
    }

    @Given("eu tenho o id de um produto")
    public void euTenhoOIdDeUmProduto() {
        this.id = 1111111111111111111L;
    }

    @When("busco um produto")
    public void buscoUmProduto() {
        this.productResponse = this.productService.findById(id);
    }

    @When("busco um produto inexistente")
    public void buscoUmProdutoInexistente() {
        this.id = -1L;
        try {
            this.productResponse = this.productService.findById(id);
        } catch (ResourceNotFoundException e) {
            this.resourceNotFoundException = e;
        }

    }

    @When("crio um produto")
    public void crioUmProduto() {
        this.productResponse = this.productService.saveOrUpdate(this.productRequest, null);
    }

    @When("atualizo um produto")
    public void atualizoUmProduto() {
        this.productResponse = this.productService.saveOrUpdate(this.productRequest, this.id);
    }

    @When("excluo um produto por id")
    public void excluoUmProduto() {
        this.productService.delete(id);
    }

    @When("excluo um produto inexistente")
    public void excluoUmProdutoInexistente() {
        this.id = -1L;
        try {
            this.productService.delete(id);
        } catch (ResourceNotFoundException e) {
            this.resourceNotFoundException = e;
        }
    }

    @Then("retorna um produto")
    public void retornaUmProduto() {
        assertThat(this.productResponse, instanceOf(ProductResponse.class));
    }

    @Then("produto nao encontrado")
    public void produtoNaoEncontrado() {
        assertThat(this.resourceNotFoundException, instanceOf(ResourceNotFoundException.class));
        assertEquals(this.resourceNotFoundException.getMessage(),String.format(MESSAGE_ID, entityName, id));
    }

    @Then("produto criado")
    public void produtoCriado() {
        assertThat(this.productResponse, instanceOf(ProductResponse.class));
    }

    @Then("produto atualizado")
    public void produtoAtualizado() {
        assertThat(this.productResponse, instanceOf(ProductResponse.class));
    }

    @Then("produto excluido")
    public void produtoExcluido() {
        //Faz nada. Originalmente, retorna codigo 200. Teste de integração indicado.
    }

    @Then("produto nao excluido")
    public void produtoNaoExcluido() {
        assertThat(this.resourceNotFoundException, instanceOf(ResourceNotFoundException.class));
        assertEquals(this.resourceNotFoundException.getMessage(),String.format(MESSAGE_ID, entityName, id));
    }
}
