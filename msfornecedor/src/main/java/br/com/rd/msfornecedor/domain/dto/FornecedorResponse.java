package br.com.rd.msfornecedor.domain.dto;

import java.io.Serializable;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.rd.msfornecedor.infrastructure.persistence.Endereco;
import br.com.rd.msfornecedor.infrastructure.persistence.Fornecedor;
import br.com.rd.msfornecedor.infrastructure.persistence.Phone;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class FornecedorResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6966466418156174001L;
	
	private final Long id;
	private final String name;
	private final Phone phone;
	private final String email;
	private final String cnpj;
	private final Endereco endereco;
	
	public static FornecedorResponse fromModel(Fornecedor fornecedor) {
		return FornecedorResponse.builder()
				.id(fornecedor.getId())
				.name(fornecedor.getName())
				.phone(fornecedor.getPhone())
				.email(fornecedor.getEmail())
				.endereco(Endereco.builder()
						.rua(fornecedor.getEndereco().getRua())
						.numero(fornecedor.getEndereco().getNumero())
						.bairro(fornecedor.getEndereco().getBairro())
						.cep(fornecedor.getEndereco().getCep())
						.cidade(fornecedor.getEndereco().getCidade())
						.estado(fornecedor.getEndereco().getEstado())
						.build())
				.cnpj(fornecedor.getCnpj())
				.build();
	}
	
	public static FornecedorResponse fromModel(Long id) {
		return FornecedorResponse.builder()
				.id(id).build();
	}
	
	public static Page<FornecedorResponse> fromModels(Page<Fornecedor> fornecedores) {
    	return new PageImpl<>(
    			fornecedores.stream().map(fornecedor -> FornecedorResponse.fromModel(fornecedor)).collect(Collectors.toList())
        );
    }

}
