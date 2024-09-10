package br.com.gestorprev.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestorprev.model.Pessoa;
import br.com.gestorprev.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	private Logger logger = Logger.getLogger(PessoaServices.class.getName());

	@Autowired
	PessoaRepository repository;
	
	public List<Pessoa> findAll() {

		logger.info("Finding all people!");
		

		return repository.findAll();
	}

	public Pessoa  findById(Long id) {
		
		logger.info("Finding one person!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
	}
	
	public Pessoa create(Pessoa pessoa) {

		logger.info("Creating one person!");
		
		return repository.save(pessoa);
	}
	
	public Pessoa update(Pessoa pessoa) {
		
		logger.info("Updating one person!");

		var entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
			entity.setCpf(pessoa.getCpf());
			entity.setNome(pessoa.getNome());

			return repository.save(pessoa);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		repository.delete(entity);
	}
	
}
