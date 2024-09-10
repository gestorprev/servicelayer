package br.com.gestorprev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorprev.model.Pessoa;
import br.com.gestorprev.services.PessoaServices;

@RestController
@RequestMapping("/pessoa")//projeto start aqui
public class PessoaController {
	
	@Autowired
	private PessoaServices service;
	///private PersonServices service = new PersonServices();
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return service.create(pessoa);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return service.update(pessoa);
	}
	
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}