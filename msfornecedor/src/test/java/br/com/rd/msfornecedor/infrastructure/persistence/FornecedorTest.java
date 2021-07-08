package br.com.rd.msfornecedor.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FornecedorTest {
	
	@Test
	void nenhumAtributoDeFornecedorDeveSerNuloComExcecaoDeIdENumero() {
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,null,new Phone("12345678910"),"email@email.com",new Endereco("rua","cep","bairro","numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone(null),"email@email.com",new Endereco("rua","cep","bairro","numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",null,"email@email.com",new Endereco("rua","cep","bairro","numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),null,new Endereco("rua","cep","bairro","numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco(null,"cep","bairro","numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua",null,"bairro","numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua","cep",null,"numero","cidade","estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua","cep","bairro","numero",null,"estado"),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua","cep","bairro","numero","cidade",null),"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",null,"16.068.964/0001-01"));
		assertThrows(NullPointerException.class, ()-> new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua","cep","bairro","numero","cidade","estado"),null));
	}
}
