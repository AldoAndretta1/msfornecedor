package br.com.rd.mscliente.domain.dto;

import java.io.Serializable;

import br.com.rd.mscliente.infrastructure.persistence.client.Client;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ClientRequest implements Serializable {

	private static final long serialVersionUID = -2887154774421145280L;

	private final Long id;

	private final String name;

	private final String phone;

	private final String email;

	public static Client toModel(ClientRequest request) {
		return Client.builder()
				.id(request.getId())
				.name(request.getName())
				.phone(request.getPhone())
				.email(request.getEmail())
				.build();
	}
}
