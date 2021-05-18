package br.com.rd.mscliente.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rd.mscliente.domain.dto.ClientRequest;
import br.com.rd.mscliente.domain.dto.ClientResponse;
import br.com.rd.mscliente.exception.ResourceNotFoundException;
import br.com.rd.mscliente.infrastructure.persistence.client.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	public ClientResponse save(ClientRequest clientRequest) {
		return ClientResponse.fromModel(this.clientRepository.save(ClientRequest.toModel(clientRequest)));
	}
	
	public Page<ClientResponse> findAll(Pageable pageable) {
		return ClientResponse.fromModels(this.clientRepository.findAll(pageable));
	}
	
	public ClientResponse findById(Long id) {
		return ClientResponse.fromModel(this.clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", id)));
	}
}