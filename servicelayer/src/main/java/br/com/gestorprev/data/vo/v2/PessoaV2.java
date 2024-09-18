package br.com.gestorprev.data.vo.v2;

import java.io.Serializable;
import java.util.Objects;

public class PessoaV2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Long idsexo;
	private String cpf;
	
	public PessoaV2() {}

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
		return Objects.hash(cpf, id, idsexo, nome);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(idsexo, other.idsexo)
				&& Objects.equals(nome, other.nome);
	}
}
