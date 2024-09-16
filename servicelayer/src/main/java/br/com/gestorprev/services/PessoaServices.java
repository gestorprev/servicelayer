package br.com.gestorprev.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestorprev.data.vo.v1.PessoaVO;
import br.com.gestorprev.mapper.DozerMapper;
import br.com.gestorprev.model.Pessoa;
import br.com.gestorprev.repositories.PessoaRepository;

@Service
public class PessoaServices {
	
	private Logger logger = Logger.getLogger(PessoaServices.class.getName());

	@Autowired
	PessoaRepository repository;
	
	public List<PessoaVO> findAll() {

		logger.info("Finding all people!");
		

		return DozerMapper.parseListObjects(repository.findAll(), PessoaVO.class);
	}

	public PessoaVO findById(Long id) {
		
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		return DozerMapper.parseObject(entity, PessoaVO.class);
	}
	
	public PessoaVO create(PessoaVO pessoa) {

		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(pessoa, Pessoa.class);
		var vo = DozerMapper.parseObject(repository.save(entity),PessoaVO.class);
		return vo;
		
	}
	
	public PessoaVO update(PessoaVO pessoa) {
		
		logger.info("Updating one person!");

		var entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
			entity.setCpf(pessoa.getCpf());
			entity.setNome(pessoa.getNome());

			var vo = DozerMapper.parseObject(repository.save(entity),PessoaVO.class);
			return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		repository.delete(entity);
	}
	
}
