package br.com.rd.mscliente.domain.dto;

import java.io.Serializable;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.rd.mscliente.infrastructure.persistence.client.Client;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ClientResponse implements Serializable {
	
	private static final long serialVersionUID = 4212085077623608213L;

	private final Long id;
	
    private final String name;
	
    private final String phone;
    
    private final String email;
    
    public static ClientResponse fromModel(Client client) {
    	return ClientResponse.builder()
    			.id(client.getId())
    			.name(client.getName())
    			.phone(client.getPhone())
    			.email(client.getEmail())
    			.build();
    }
    
    public static Page<ClientResponse> fromModels(Page<Client> clients) {
    	return new PageImpl<>(
    			clients.stream().map(client -> ClientResponse.fromModel(client)).collect(Collectors.toList())
        );
    }
}