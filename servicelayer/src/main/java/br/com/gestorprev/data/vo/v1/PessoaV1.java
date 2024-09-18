package br.com.gestorprev.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class PessoaV1 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	
	public PessoaV1() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
