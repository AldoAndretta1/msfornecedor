package br.com.rd.mscliente.controller;

import br.com.rd.mscliente.domain.dto.ProductRequest;
import br.com.rd.mscliente.domain.dto.ProductResponse;
import br.com.rd.mscliente.service.ProductService;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "Buscar Cliente por id", authorizations = { @Authorization(value = "OAuth2") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido") })
    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id")Long id) {

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

        return ResponseEntity.ok(productService.save(request));
    }
}
