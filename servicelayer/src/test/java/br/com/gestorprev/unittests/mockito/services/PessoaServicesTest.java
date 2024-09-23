package br.com.gestorprev.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gestorprev.data.vo.v1.PessoaV1;
//import br.com.gestorprev.exceptions.RequiredObjectIsNullException;
import br.com.gestorprev.model.Pessoa;
import br.com.gestorprev.repositories.PessoaRepository;
import br.com.gestorprev.services.PessoaServices;
import br.com.gestorprev.unittests.mapper.mocks.MockPessoa;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PessoaServicesTest {
	
	MockPessoa input;
	
	@InjectMocks
	private PessoaServices service;
	
	@Mock
	PessoaRepository repository;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPessoa();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Pessoa pessoa = input.mockEntity(1);
		pessoa.setId(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(pessoa));
		var result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		System.out.println(result.toString());
		assertTrue(result.toString().contains("links: [</api/v1/pessoa/1>;rel=\"self\"]"));
		assertEquals("34724772883", result.getCpf());

	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
