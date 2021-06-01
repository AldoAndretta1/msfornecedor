package br.com.rd.msproduct.controller;


import br.com.rd.msproduct.domain.dto.ProductRequest;
import br.com.rd.msproduct.domain.dto.ProductResponse;
import br.com.rd.msproduct.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Api(tags = { "Product" })
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Buscar produto por id", authorizations = { @Authorization(value = "OAuth2") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido") })
    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
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
    @PutMapping("id")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long id, @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(this.productService.saveOrUpdate(request, id));
    }

    @ApiOperation(value = "Deleta um produto existente", authorizations = { @Authorization(value="OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {

        this.productService.delete(id);

        return ResponseEntity.ok().build();
    }
}
