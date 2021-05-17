package br.com.rd.mscliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rd.mscliente.domain.dto.ClientRequest;
import br.com.rd.mscliente.domain.dto.ClientResponse;
import br.com.rd.mscliente.infrastructure.persistence.client.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	public ClientResponse save(ClientRequest clientRequest) {
		return ClientResponse.fromModel(this.clientRepository.save(ClientRequest.toModel(clientRequest)));
	}
	
	public List<ClientResponse> findAll() {
		return ClientResponse.fromModels(this.clientRepository.findAll());
	}
	
	public ClientResponse findById(Long id) {
		return ClientResponse.fromModel(this.clientRepository.findById(id).orElse(null));
	}
	
	public List<ClientResponse> findByName(String name) {
		return ClientResponse.fromModels(this.clientRepository.findByNameContainsIgnoreCase(name));
	}
}