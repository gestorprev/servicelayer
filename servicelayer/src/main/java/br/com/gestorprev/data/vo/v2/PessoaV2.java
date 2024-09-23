package br.com.gestorprev.data.vo.v2;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//ordem do json
@JsonPropertyOrder({"id","nome","idSexo", "cpf"})
public class PessoaV2 extends RepresentationModel<PessoaV2> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")//renomear como vai aparecer no json
	private Long key;//não posso chamar de id, pois o hateos já tem 
	private String nome;
	private Long idsexo;
	private String cpf;
	
	public PessoaV2() {}


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
		return idsexo;
	}

	public void setIdSexo(Long idsexo) {
		this.idsexo = idsexo;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, key, idsexo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaV2 other = (PessoaV2) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(key, other.key) && Objects.equals(idsexo, other.idsexo)
				&& Objects.equals(nome, other.nome);
	}
}
