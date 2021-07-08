package br.com.rd.msfornecedor.infrastructure.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fornecedor")
@Getter
@Setter
@Builder
public class Fornecedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5477089707634344386L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column
	@NotBlank
	@NotNull
	@NonNull
	private String name;
	
	@Column
	@NotNull
	@Embedded
	@NonNull
	private Phone phone;
	
	@Email
	@NotBlank
	@NotNull
	@NonNull
	private String email;
	
	@Column
	@NotNull
	@Embedded
	@NonNull
	private Endereco endereco;
	
	@CNPJ
	@Column
	@NotNull
	@NotBlank
    @EqualsAndHashCode.Include
    @NonNull
	private String cnpj;
}
