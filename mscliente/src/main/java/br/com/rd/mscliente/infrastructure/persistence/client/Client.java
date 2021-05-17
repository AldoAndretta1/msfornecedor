package br.com.rd.mscliente.infrastructure.persistence.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@Getter
@Setter
@Builder
public class Client implements Serializable {
	
	private static final long serialVersionUID = 5805335775258498191L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column
	@NotBlank
    @EqualsAndHashCode.Include
	private String name;
	
	@Column
	private String phone;
	
	@Column
	private String email;

}
