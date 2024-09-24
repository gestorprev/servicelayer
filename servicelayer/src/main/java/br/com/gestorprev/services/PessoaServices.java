package br.com.gestorprev.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestorprev.controllers.PessoaController;
import br.com.gestorprev.data.vo.v1.PessoaV1;
import br.com.gestorprev.data.vo.v2.PessoaV2;
import br.com.gestorprev.exceptions.RequiredObjectIsNullException;
import br.com.gestorprev.mapper.DozerMapper;
import br.com.gestorprev.mapper.PessoaMapper;
import br.com.gestorprev.model.Pessoa;
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
		
		//DozerMapper
		var pessoas = DozerMapper.parseListObjects(repository.findAll(), PessoaV1.class);
		pessoas
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(PessoaController.class).findById(p.getKey())).withSelfRel()));
		return pessoas;
		
		/*mapper
		var entity = repository.findAll();
		var vo = mapper.convertEntityToVoListV1(entity);
		vo
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(PessoaController.class).findById(p.getKey())).withSelfRel()));hateoas
		return vo;
		*/
	}
	
	public PessoaV1 findById(Long id) {
		logger.info("Retornando um id!");
		
		//DozerMapper
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
			var vo = DozerMapper.parseObject(entity, PessoaV1.class);
			vo.add(linkTo(methodOn(PessoaController.class).findById(id)).withSelfRel());
			return vo;
		
		/*mapper
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		var vo = mapper.convertEntityToVoV1(entity);
		vo.add(linkTo(methodOn(PessoaController.class).findById(id)).withSelfRel());//hateos
		return vo;
		*/
	}
	
	//create
	public PessoaV1 create(PessoaV1 pessoa) {
		logger.info("Creating one person!");
		if (pessoa == null) throw new RequiredObjectIsNullException();
		
		//DozerMapper
		var entity = DozerMapper.parseObject(pessoa, Pessoa.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), PessoaV1.class);
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
		
		/*mapper
		var entity = mapper.convertVoToEntityV1(pessoa);
		var vo = mapper.convertEntityToVoV1(repository.save(entity));
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());//hateos
		return vo;
		*/
	}
	public PessoaV2 createV2(PessoaV2 pessoa) {
		logger.info("Creating one person v2!");
		if (pessoa == null) throw new RequiredObjectIsNullException();
		
		//mapper
		var entity = mapper.convertVoToEntityV2(pessoa);
		var vo = mapper.convertEntityToVoV2(repository.save(entity));
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());//hateos
		return vo;
		
	}
	
	//update
	public PessoaV1 update(PessoaV1 pessoa) {
		logger.info("Updating one person!");
		if (pessoa == null) throw new RequiredObjectIsNullException();
		
		//DozerMapper
		var entity = repository.findById(pessoa.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setNome(pessoa.getNome());
		entity.setCpf(pessoa.getCpf());
		entity.setRgn(pessoa.getRgn());
		var vo =  DozerMapper.parseObject(repository.save(entity), PessoaV1.class);
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
			
		/*mapper
		var entity = repository.findById(pessoa.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
			entity.setNome(pessoa.getNome());
			entity.setCpf(pessoa.getCpf());
			entity.setRg(pessoa.getRgN());
		//var vo = DozerMapper.parseObject(repository.save(entity),PessoaV1.class);
		var vo = mapper.convertEntityToVoV1(repository.save(entity));
		vo.add(linkTo(methodOn(PessoaController.class).findById(vo.getKey())).withSelfRel());//hateos
		return vo;
		*/
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
		repository.delete(entity);
	}
	
}
