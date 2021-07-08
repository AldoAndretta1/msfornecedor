package br.com.rd.msfornecedor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.msfornecedor.domain.dto.FornecedorRequest;
import br.com.rd.msfornecedor.domain.dto.FornecedorResponse;
import br.com.rd.msfornecedor.service.FornecedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fornecedores")
@Api(tags = { "Fornecedor" })
public class FornecedorController {

	@Autowired
	private final FornecedorService fornecedorService;
	
	@ApiOperation(value = "Buscar todos Fornecedores", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@GetMapping
	public ResponseEntity<Page<FornecedorResponse>> findAll(@PageableDefault(size=50) Pageable pageable) {
		return ResponseEntity.ok(fornecedorService.findAll(pageable));
	}
	
	@ApiOperation(value = "Buscar Fornecedor por id", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@GetMapping("{id}")
	public ResponseEntity<FornecedorResponse> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(fornecedorService.findById(id));
	}
	
	@ApiOperation(value = "Salvar um Fornecedor", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@PostMapping
	public ResponseEntity<FornecedorResponse> save(@Valid @RequestBody FornecedorRequest request) {
		return ResponseEntity.ok(fornecedorService.saveOrUpdate(request, null));
	}
	
	@ApiOperation(value = "Atualizar um fornecedor existente", authorizations = { @Authorization(value="OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @PutMapping("id")
    public ResponseEntity<FornecedorResponse> update(@PathVariable("id") Long id, @Valid @RequestBody FornecedorRequest request) {
        return ResponseEntity.ok(this.fornecedorService.saveOrUpdate(request, id));
    }
	
	@ApiOperation(value = "Deleta um fornecedor existente", authorizations = { @Authorization(value="OAuth2") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
            @ApiResponse(code = 401, message = "Acesso não autorizado"),
            @ApiResponse(code = 500, message = "Erro desconhecido")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<FornecedorResponse> deleteById(@PathVariable("id") Long id) {
        this.fornecedorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
