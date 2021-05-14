package br.com.rd.mscliente.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mscliente")
@Slf4j
@Api(tags = {"Mscliente"})
public class MsclienteController {

    @ApiOperation(
        value = "Exemplo de API - Get",
        authorizations = {@Authorization(value="OAuth2")})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
        @ApiResponse(code = 401, message = "Acesso não autorizado"),
        @ApiResponse(code = 500, message = "Erro desconhecido")})
    @GetMapping
    public ResponseEntity<String> getExemplo() {
        log.info("Exemplo de API - Get. application=Hello World!");
        return ResponseEntity.ok("Get: Hello World!");
    }

    @ApiOperation(
        value = "Exemplo de API - Post",
        authorizations = {@Authorization(value="OAuth2")})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
        @ApiResponse(code = 401, message = "Acesso não autorizado"),
        @ApiResponse(code = 500, message = "Erro desconhecido")})
    @PostMapping
    public ResponseEntity<String> postExemplo(
        @ApiParam(value = "Name - Digite um nome...")
        @RequestParam("name") Optional<String> name
    ) {
        log.info("Exemplo de API - Post. application=Hello World!");
        return ResponseEntity.ok("Post: Hello World!");
    }
}