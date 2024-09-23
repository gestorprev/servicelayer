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

import br.com.gestorprev.data.vo.v1.PessoaV1;
import br.com.gestorprev.data.vo.v2.PessoaV2;
import br.com.gestorprev.services.PessoaServices;

@RestController
@RequestMapping("/api")//projeto inicia aqui
public class PessoaController {
	
	@Autowired
	private PessoaServices service;
	///private PersonServices service = new PersonServices();
	
	//getall
	//@RequestMapping(method=RequestMethod.GET,
	@GetMapping(value = "/v1/pessoa", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public List<PessoaV1> findAll() {
		return service.findAll();
	}
	
	//getid
	@GetMapping(value = "/v1/pessoa/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public PessoaV1 findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	//post
	@PostMapping(value = "/v1/pessoa", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public PessoaV1 create(@RequestBody PessoaV1 pessoa) {
		return service.create(pessoa);
	}
	@PostMapping(value = "/v2/pessoa", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public PessoaV2 createV2(@RequestBody PessoaV2 pessoa) {
		return service.createV2(pessoa);
	}
	
	//put
	@PutMapping(value = "/v1/pessoa", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public PessoaV1 update(@RequestBody PessoaV1 pessoa) {
		return service.update(pessoa);
	}
	
	//delete
	@DeleteMapping(value = "/v1/pessoa/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}