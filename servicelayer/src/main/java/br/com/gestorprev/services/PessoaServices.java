package br.com.gestorprev.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestorprev.data.vo.v1.PessoaV1;
import br.com.gestorprev.data.vo.v2.PessoaV2;
import br.com.gestorprev.mapper.DozerMapper;
import br.com.gestorprev.mapper.PessoaMapper;
import br.com.gestorprev.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	private Logger logger = Logger.getLogger(PessoaServices.class.getName());

	@Autowired
	PessoaRepository repository;
	
	@Autowired
	PessoaMapper mapper;
	
	public List<PessoaV1> findAll() {

		logger.info("Finding all people!");
		
		return DozerMapper.parseListObjects(repository.findAll(), PessoaV1.class);
	}
	
	public PessoaV1 findById(Long id) {
		
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		return DozerMapper.parseObject(entity, PessoaV1.class);
	}
	
	//create - CONFUSO DOZER OU MAPPER?
	public PessoaV1 create(PessoaV1 pessoa) {

		logger.info("Creating one person!");
		
		//var entity = DozerMapper.parseObject(pessoa, Pessoa.class);
		//var vo = DozerMapper.parseObject(repository.save(entity),PessoaV1.class);
		var entity = mapper.convertVoToEntityV1(pessoa);
		var vo = mapper.convertEntityToVoV1(repository.save(entity));
		return vo;
		
	}
	public PessoaV2 createV2(PessoaV2 pessoa) {

		logger.info("Creating one person v2!");
		
		var entity = mapper.convertVoToEntityV2(pessoa);
		var vo = mapper.convertEntityToVoV2(repository.save(entity));
		return vo;
		
	}
	
	//update
	public PessoaV1 update(PessoaV1 pessoa) {
		
		logger.info("Updating one person!");

		var entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
			entity.setCpf(pessoa.getCpf());
			entity.setNome(pessoa.getNome());

		var vo = DozerMapper.parseObject(repository.save(entity),PessoaV1.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		repository.delete(entity);
	}
	
}
