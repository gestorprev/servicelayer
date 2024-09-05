package br.com.gestorprev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.gestorprev.model.Pessoa;

@Service
public class PessoaServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PessoaServices.class.getName());

	public List<Pessoa> findAll() {

		logger.info("Finding all people!");
		
		List<Pessoa> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Pessoa pessoa = mockPessoa(i);
			persons.add(pessoa);
		}
		return persons;
	}

	public Pessoa  findById(String id) {
		
		logger.info("Finding one person!");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setCpf("34724772883");
		pessoa.setNome("Rodrigo");
		return pessoa;
	}
	
	public Pessoa create(Pessoa pessoa) {

		logger.info("Creating one person!");
		
		return pessoa;
	}
	
	public Pessoa update(Pessoa pessoa) {
		
		logger.info("Updating one person!");
		
		return pessoa;
	}
	
	public void delete(String id) {
		
		logger.info("Deleting one person!");
	}
	
	private Pessoa mockPessoa(int i) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setCpf("cpf " + i);
		pessoa.setNome("nome " + i);
		return pessoa;
	}
}
