package br.com.gestorprev.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cpf;
	private String nome;
	
	public Pessoa() {}

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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
	
}
