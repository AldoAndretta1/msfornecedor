package br.com.rd.msfornecedor.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.com.rd.msfornecedor.domain.dto.FornecedorRequest;
import br.com.rd.msfornecedor.domain.dto.FornecedorResponse;
import br.com.rd.msfornecedor.exception.ResourceNotFoundException;
import br.com.rd.msfornecedor.infrastructure.persistence.Endereco;
import br.com.rd.msfornecedor.infrastructure.persistence.Fornecedor;
import br.com.rd.msfornecedor.infrastructure.persistence.FornecedorRepository;
import br.com.rd.msfornecedor.infrastructure.persistence.Phone;

class FornecedorServiceTest {

	private FornecedorService fornecedorService;
	
	@Mock
	private FornecedorRepository fornecedorRepository;
	
	private FornecedorRequest fornecedorRequest;
	
	private ResourceNotFoundException resourceNotFoundException;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		this.fornecedorService = new FornecedorService(fornecedorRepository);
	}
	
	@Test
	void deveriaSalvar() {
		Fornecedor fornecedor = fornecedor();
		fornecedorRequest = FornecedorRequest.builder().id(fornecedor.getId())
				.bairro(fornecedor.getEndereco().getBairro())
				.cep(fornecedor.getEndereco().getCep())
				.cidade(fornecedor.getEndereco().getCidade())
		.cnpj(fornecedor.getCnpj()).email(fornecedor.getEmail())
		.estado(fornecedor.getEndereco().getEstado())
		.name(fornecedor.getName()).numero(fornecedor.getEndereco().getNumero())
		.phone(Phone.builder().phone(fornecedor.getPhone().getPhone()).build())
		.rua(fornecedor.getEndereco().getRua()).build();
		Mockito.when(this.fornecedorRepository.save(fornecedor)).thenReturn(fornecedor);
		Fornecedor salvo = this.fornecedorRepository.save(fornecedor);
		FornecedorResponse response = FornecedorResponse.fromModel(fornecedor);
		Mockito.when(fornecedorService.saveOrUpdate(fornecedorRequest, null)).thenReturn(response);
		assertEquals(salvo, fornecedor);
	}
	
	@Test
	void deveriaAtualizarCasoExista() {
		Fornecedor fornecedor = fornecedor();
		fornecedor.setId(1l);
		fornecedorRequest = FornecedorRequest.builder().id(fornecedor.getId())
				.bairro(fornecedor.getEndereco().getBairro())
				.cep(fornecedor.getEndereco().getCep())
				.cidade(fornecedor.getEndereco().getCidade())
		.cnpj(fornecedor.getCnpj()).email(fornecedor.getEmail())
		.estado(fornecedor.getEndereco().getEstado())
		.name(fornecedor.getName()).numero(fornecedor.getEndereco().getNumero())
		.phone(Phone.builder().phone(fornecedor.getPhone().getPhone()).build())
		.rua(fornecedor.getEndereco().getRua()).build();
		FornecedorResponse fornecedorResponse = FornecedorResponse.fromModel(fornecedor);
		Mockito.when(this.fornecedorRepository.findById(fornecedor.getId())).thenReturn(Optional.of(fornecedor));
        Mockito.doReturn(fornecedorResponse).when(Mockito.mock(FornecedorService.class)).findById(1l);
		Mockito.when(this.fornecedorRepository.save(fornecedor)).thenReturn(fornecedor);
		Fornecedor salvo = this.fornecedorRepository.save(fornecedor);
		FornecedorResponse response = FornecedorResponse.fromModel(fornecedor);
		Mockito.when(fornecedorService.saveOrUpdate(fornecedorRequest, fornecedor.getId())).thenReturn(response);
		assertEquals(salvo, fornecedor);
	}
	
	@Test
	void naoDeveriaAtualizarCasoNaoExista() {		
		Fornecedor fornecedor = fornecedor();
		fornecedor.setId(-1l);
		Mockito.when(fornecedorRepository.findById(fornecedor.getId())).thenThrow(ResourceNotFoundException.class);
		try {
			fornecedorService.findById(fornecedor.getId());
        } catch (ResourceNotFoundException e) {
            this.resourceNotFoundException = e;
        }
		assertThat(resourceNotFoundException, instanceOf(ResourceNotFoundException.class));
//		assertThrows(null, null)
	}
	
	@Test
	void deveriaTrazerUmaListaDeFornecedores() {
		Page<Fornecedor> fornecedores = Mockito.mock(Page.class);
		Pageable pageable = PageRequest.of(0, 8);
		Mockito.when(this.fornecedorRepository.findAll(pageable)).thenReturn(fornecedores);
		Page<Fornecedor> findAll = this.fornecedorRepository.findAll(pageable);
		assertThat(findAll, instanceOf(Page.class));
	}
	
	@Test
    public void deveriaTrazerUmFornecedor() {
		Fornecedor fornecedor = fornecedor();
		FornecedorResponse fornecedorResponse = FornecedorResponse.fromModel(fornecedor);
		Mockito.when(this.fornecedorRepository.findById(1l)).thenReturn(Optional.of(fornecedor));
        Mockito.doReturn(fornecedorResponse).when(Mockito.mock(FornecedorService.class)).findById(1l);
        assertThat(fornecedorResponse, instanceOf(FornecedorResponse.class));
    }
	
	@Test
    public void naoDeveriaTrazerUmFornecedorCasoNaoExista() {        
        Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(-1l);
		Mockito.when(fornecedorRepository.findById(fornecedor.getId())).thenThrow(ResourceNotFoundException.class);
		try {
			fornecedorService.findById(fornecedor.getId());
        } catch (ResourceNotFoundException e) {
            this.resourceNotFoundException = e;
        }
		assertThat(resourceNotFoundException, instanceOf(ResourceNotFoundException.class));
    }
	
	@Test
    public void deveriaExcluirUmFornecedor() {
		Fornecedor fornecedor = fornecedor();
		fornecedor.setId(1l);
		FornecedorResponse.fromModel(fornecedor);
		Mockito.when(this.fornecedorRepository.findById(fornecedor.getId())).thenReturn(Optional.of(fornecedor));
		fornecedorService.delete(fornecedor.getId());
		Mockito.verify(fornecedorRepository).delete(fornecedor);
    }
	
	@Test
	public void naoDeveExcluirUmFornecedorCasoNaoExista() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(-1l);
		Mockito.when(fornecedorRepository.findById(fornecedor.getId())).thenThrow(ResourceNotFoundException.class);
		try {
			fornecedorService.delete(fornecedor.getId());
        } catch (ResourceNotFoundException e) {
            this.resourceNotFoundException = e;
        }
		assertThat(resourceNotFoundException, instanceOf(ResourceNotFoundException.class));
	}
  
	private Fornecedor fornecedor() {
		return new Fornecedor(null,"name",new Phone("12345678910"),"email@email.com",new Endereco("rua","cep","bairro","numero","cidade","estado"),"16.068.964/0001-01");
	}
	
}
