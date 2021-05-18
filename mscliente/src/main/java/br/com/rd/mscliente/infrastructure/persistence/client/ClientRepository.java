package br.com.rd.mscliente.infrastructure.persistence.client;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByNameContainsIgnoreCase(String name);
	
	Page<Client> findAll(Pageable pageable);
}
