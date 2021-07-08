package br.com.rd.msfornecedor.domain.dto;

import java.io.Serializable;

import br.com.rd.msfornecedor.infrastructure.persistence.Endereco;
import br.com.rd.msfornecedor.infrastructure.persistence.Fornecedor;
import br.com.rd.msfornecedor.infrastructure.persistence.Phone;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FornecedorRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2725063796247222050L;
	
	private final Long id;
	private final String name;
	private final Phone phone;
	private final String email;
	private final String cnpj;
	private final Endereco endereco;
	private final String rua;
	private final String numero;
	private final String bairro;
	private final String cep;
	private final String cidade;
	private final String estado;
	
	public static Fornecedor toModel(FornecedorRequest request) {
		return Fornecedor.builder()
				.id(request.getId())
				.name(request.getName())
				.phone(request.getPhone())
				.email(request.getEmail())
				.endereco(Endereco.builder()
						.rua(request.getRua())
						.numero(request.getNumero())
						.bairro(request.getBairro())
						.cep(request.getCep())
						.cidade(request.getCidade())
						.estado(request.getEstado())
						.build())
				.cnpj(request.getCnpj())
				.build();
	}
}