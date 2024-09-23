package br.com.gestorprev.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//ordem do json
@JsonPropertyOrder({"id","nome","idSexo", "cpf","rg"})
public class PessoaV1 extends RepresentationModel<PessoaV1> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")//renomear como vai aparecer no json
	private Long key; //não posso chamar de id, pois o hateos já tem 
	//@JsonIgnore//não mostrar no json
	private String nome;
	@JsonProperty("idSexo")//renomear como vai aparecer no json
	private Long idSexo;
	private String cpf;
	@JsonProperty("rg")
	private String rgN;
	
	public PessoaV1() {}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Long idSexo) {
		this.idSexo = idSexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public String getRgN() {
		return rgN;
	}

	public void setRgN(String rgN) {
		this.rgN = rgN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, key, idSexo, nome, rgN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaV1 other = (PessoaV1) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(key, other.key) && Objects.equals(idSexo, other.idSexo)
				&& Objects.equals(nome, other.nome) && Objects.equals(rgN, other.rgN);
	}
}
/*
package br.com.gestorprev.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class PessoaV1 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cpf;
	private String nome;
	
	public PessoaV1() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaV1 other = (PessoaV1) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
	
}
*/
