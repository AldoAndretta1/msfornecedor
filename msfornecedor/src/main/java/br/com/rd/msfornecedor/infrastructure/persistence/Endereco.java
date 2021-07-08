package br.com.rd.msfornecedor.infrastructure.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor()
@Builder
@Embeddable
public class Endereco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7611268859989620165L;

	@NotBlank
	@NotNull
	@Column
	@Getter
	@Setter
	@NonNull
	private String rua;
	
	@NotBlank
	@NotNull
	@Column
	@Getter
	@Setter
	@NonNull
	private String cep;
	
	@NotBlank
	@NotNull
	@Column
	@Getter
	@Setter
	@NonNull
	private String bairro;
	
	@Column
	@Getter
	@Setter
	private String numero;
	
	@NotBlank
	@NotNull
	@Column
	@Getter
	@Setter
	@NonNull
	private String cidade;
	
	@NotBlank
	@NotNull
	@Column
	@Getter
	@Setter
	@NonNull
	private String estado;
}
