package br.com.rd.mscliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.mscliente.domain.dto.ClientRequest;
import br.com.rd.mscliente.domain.dto.ClientResponse;
import br.com.rd.mscliente.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@Api(tags = { "Client" })
public class ClientController {
	
	private final ClientService clientService;

	@ApiOperation(value = "Buscar todos Clientes", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@GetMapping
	public ResponseEntity<List<ClientResponse>> findAll() {
		return ResponseEntity.ok(clientService.findAll());
	}
	
	@ApiOperation(value = "Buscar Cliente por id", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@GetMapping("{id}")
	public ResponseEntity<ClientResponse> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(clientService.findById(id));
	}
	
	@ApiOperation(value = "Buscar Cliente por nome", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@GetMapping("findByName/{name}")
	public ResponseEntity<List<ClientResponse>> findByName(@PathVariable("name") String name) {
		return ResponseEntity.ok(clientService.findByName(name));
	}

	@ApiOperation(value = "Salvar um Cliente", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@PostMapping
	public ResponseEntity<ClientResponse> save(@Valid @RequestBody ClientRequest request) {
		return ResponseEntity.ok(clientService.save(request));
	}
}