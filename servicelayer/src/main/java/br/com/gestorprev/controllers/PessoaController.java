package br.com.gestorprev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorprev.data.vo.v1.PessoaVO;
import br.com.gestorprev.services.PessoaServices;

@RestController
@RequestMapping("/pessoa")//projeto inicia aqui
public class PessoaController {
	
	@Autowired
	private PessoaServices service;
	///private PersonServices service = new PersonServices();
	
	//@RequestMapping(method=RequestMethod.GET,
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PessoaVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO create(@RequestBody PessoaVO pessoa) {
		return service.create(pessoa);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO update(@RequestBody PessoaVO pessoa) {
		return service.update(pessoa);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}