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
import br.com.gestorprev.services.PessoaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api")//projeto inicia aqui
@Tag(name = "Cadastro de Pessoas", description = "Dados cadastrais das pessoas físicas")
public class PessoaController {
	
	@Autowired
	private PessoaServices service;
	///private PersonServices service = new PersonServices();
	
	//getall
	//@RequestMapping(method=RequestMethod.GET,
	@GetMapping(value = "/v1/pessoa", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) //MediaType.APPLICATION_YAML_VALUE
	//@Operation(summary = "Consulta de registros", description = "Consulta de registros",
	@Operation(description = "Consulta os registros",
			tags = {"Cadastro de Pessoas"},
			responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", 
							content = {
									@Content(
											mediaType = "application/json",
											array = @ArraySchema(schema = @Schema(implementation = PessoaV1.class))
									)
					}),
					@ApiResponse(description = "Dados Inválidos", responseCode = "400", content = @Content),
					@ApiResponse(description = "Dados Inválidos", responseCode = "400", content = @Content),
					@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
					@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
					@ApiResponse(description = "Erro interno", responseCode = "500", content = @Content)
			})
	public List<PessoaV1> findAll() {
		return service.findAll();
	}
	
	//getid
	@GetMapping(value = "/v1/pessoa/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(description = "Consulta o registro",
			tags = {"Cadastro de Pessoas"},
			responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", 
							content = @Content(schema = @Schema(implementation = PessoaV1.class))
								),
					@ApiResponse(description = "Processada com sucesso", responseCode = "204", content = @Content),
					@ApiResponse(description = "Dados Inválidos", responseCode = "400", content = @Content),
					@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
					@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
					@ApiResponse(description = "Erro interno", responseCode = "500", content = @Content)
			})
	public PessoaV1 findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	//post
	@PostMapping(value = "/v1/pessoa", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(description = "Inseri registros em JSON, XML ou YML",
	tags = {"Cadastro de Pessoas"},
	responses = {
			@ApiResponse(description = "Sucesso", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PessoaV1.class))
						),
			@ApiResponse(description = "Dados Inválidos", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Erro interno", responseCode = "500", content = @Content)
	})
	public PessoaV1 create(@RequestBody PessoaV1 pessoa) {
		return service.create(pessoa);
	}
	
	/*
	@PostMapping(value = "/v2/pessoa", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PessoaV2 createV2(@RequestBody PessoaV2 pessoa) {
		return service.createV2(pessoa);
	}
	*/
	
	//put
	@PutMapping(value = "/v1/pessoa", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(description = "Atualiza registros em JSON, XML ou YML",
	tags = {"Cadastro de Pessoas"},
	responses = {
			@ApiResponse(description = "Sucesso", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PessoaV1.class))
						),
			@ApiResponse(description = "Processada com sucesso", responseCode = "204", content = @Content),
			@ApiResponse(description = "Dados Inválidos", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
			@ApiResponse(description = "Erro interno", responseCode = "500", content = @Content)
	})
	public PessoaV1 update(@RequestBody PessoaV1 pessoa) {
		return service.update(pessoa);
	}
	
	//delete
	@DeleteMapping(value = "/v1/pessoa/{id}")
	@Operation(description = "Remove registros em JSON, XML ou YML",
	tags = {"Cadastro de Pessoas"},
	responses = {
			@ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
			@ApiResponse(description = "Dados Inválidos", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
			@ApiResponse(description = "Erro interno", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}