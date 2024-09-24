package br.com.gestorprev.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

//ordem do json
@JsonPropertyOrder({"id","nome","idestadocivil", "cpf","rgn"})
public class PessoaV1 extends RepresentationModel<PessoaV1> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@JsonIgnore//não mostrar no json
	
	@JsonProperty("id")//renomear como vai aparecer no json
	@Mapping("id")
	private Long key; //não posso chamar de id, pois o hateos já tem 
	
	private String nome;
	
	@JsonProperty("idEstadoCivil")
	@Mapping("idestadocivil")
	private long idestadocivil;

	private String cpf;
	
	//@JsonProperty("rgNumero")
	@Mapping("rgn")
	private String rgn;
	
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

	
	public long getIdestadocivil() {
		return idestadocivil;
	}

	public void setIdestadocivil(long idestadocivil) {
		this.idestadocivil = idestadocivil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getRgn() {
		return rgn;
	}

	public void setRgn(String rgn) {
		this.rgn = rgn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, idestadocivil, key, nome, rgn);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaV1 other = (PessoaV1) obj;
		return Objects.equals(cpf, other.cpf) && idestadocivil == other.idestadocivil && Objects.equals(key, other.key)
				&& Objects.equals(nome, other.nome) && Objects.equals(rgn, other.rgn);
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
