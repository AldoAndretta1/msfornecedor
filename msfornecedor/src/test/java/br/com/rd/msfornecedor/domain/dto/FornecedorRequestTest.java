package br.com.rd.msfornecedor.domain.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.rd.msfornecedor.infrastructure.persistence.Endereco;
import br.com.rd.msfornecedor.infrastructure.persistence.Fornecedor;
import br.com.rd.msfornecedor.infrastructure.persistence.Phone;

class FornecedorRequestTest {
	
	private FornecedorRequest fornecedorRequest;

	@Test
	void deveriaCriarUmModel() {
		Fornecedor fornecedor = fornecedor();
		fornecedorRequest = FornecedorRequest.builder().id(fornecedor.getId())
				.bairro(fornecedor.getEndereco().getBairro())
				.cep(fornecedor.getEndereco().getCep())
				.cidade(fornecedor.getEndereco().getCidade())
		.cnpj(fornecedor.getCnpj()).email(fornecedor.getEmail())
		.estado(fornecedor.getEndereco().getEstado())
		.name(fornecedor.getName()).numero(fornecedor.getEndereco().getNumero())
		.phone(Phone.builder().phone(fornecedor.getPhone().getPhone()).build())
		.rua(fornecedor.getEndereco().getRua()).build();
		assertEquals(fornecedor, FornecedorRequest.toModel(fornecedorRequest));
	}
	
	private Fornecedor fornecedor() {
		return new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua","cep","bairro","numero","cidade","estado"),"16.068.964/0001-01");
	}	
}
