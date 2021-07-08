package br.com.rd.msfornecedor.infrastructure.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Builder
public class Phone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7633787034424695758L;
	
	@NotBlank
	@NotNull
	@Setter
	@Getter
	@Column
	private String phone;
	
	public Phone(String phone) {
		if(!phone.matches("\\d{10}|\\d{11}")) {
			throw new IllegalArgumentException("Telefone Invalido!");
		}
		this.phone = phone;
	}	
}
