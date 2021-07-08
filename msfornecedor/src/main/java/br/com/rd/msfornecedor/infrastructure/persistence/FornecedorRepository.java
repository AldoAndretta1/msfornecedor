package br.com.rd.msfornecedor.infrastructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	
	Page<Fornecedor> findAll(Pageable pageable);
	
}
