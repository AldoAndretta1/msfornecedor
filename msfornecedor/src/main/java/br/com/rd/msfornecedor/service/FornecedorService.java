package br.com.rd.msfornecedor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rd.msfornecedor.domain.dto.FornecedorRequest;
import br.com.rd.msfornecedor.domain.dto.FornecedorResponse;
import br.com.rd.msfornecedor.exception.ResourceNotFoundException;
import br.com.rd.msfornecedor.infrastructure.persistence.Fornecedor;
import br.com.rd.msfornecedor.infrastructure.persistence.FornecedorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FornecedorService {
	
	@Autowired
	private final FornecedorRepository fornecedorRepository;
	
	public FornecedorResponse saveOrUpdate(FornecedorRequest fornecedorRequest, Long id) {

        Fornecedor fornecedor;

        if (id == null) {
            fornecedor = FornecedorRequest.toModel(fornecedorRequest);
            return FornecedorResponse.fromModel(this.fornecedorRepository.save(fornecedor));
        }

        fornecedor = FornecedorRequest.toModel(fornecedorRequest);
        fornecedor.setId(id);

        return FornecedorResponse.fromModel(this.fornecedorRepository.save(fornecedor));
    }
	
    public void delete(Long id) {
        Fornecedor fornecedor = this.fornecedorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor", id));
        this.fornecedorRepository.delete(fornecedor);
    }
	
	public Page<FornecedorResponse> findAll(Pageable pageable) {
		return FornecedorResponse.fromModels(this.fornecedorRepository.findAll(pageable));
	}
	
	public FornecedorResponse findById(Long id) {
		return FornecedorResponse.fromModel(this.fornecedorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fornecedor", id)));
	}
}