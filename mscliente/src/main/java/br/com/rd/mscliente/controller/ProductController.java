package br.com.rd.mscliente.controller;

import br.com.rd.mscliente.domain.dto.ProductRequest;
import br.com.rd.mscliente.domain.dto.ProductResponse;
import br.com.rd.mscliente.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Api(tags = { "Product" })
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Listar todos os produtos", authorizations = { @Authorization(value = "OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAll(@PageableDefault(size=50) Pageable pageableProduct) {
        return ResponseEntity.ok(this.productService.findAll(pageableProduct));
    }

    @ApiOperation(value = "Buscar produto por id", authorizations = { @Authorization(value = "OAuth2") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido") })
    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id")Long id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @ApiOperation(value = "Salvar um novo produto", authorizations = { @Authorization(value="OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(this.productService.saveOrUpdate(request, null));
    }

    @ApiOperation(value = "Atualizar um produto existente", authorizations = { @Authorization(value="OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @PostMapping
    public ResponseEntity<ProductResponse> update(@Valid @RequestBody ProductRequest request, @Valid @RequestBody Long id) {
        return ResponseEntity.ok(this.productService.saveOrUpdate(request, id));
    }

    @ApiOperation(value = "Deleta um produto existente", authorizations = { @Authorization(value="OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @GetMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {

        this.productService.delete(id);

        return ResponseEntity.ok().build();
    }
}
