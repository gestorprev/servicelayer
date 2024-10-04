package br.com.gestorprev.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = true)
	private Long idestadocivil;

	@Column(nullable = false, length = 11) //se for igual ao banco só deixo @Column
	private String cpf;
	
	private String rgn;
	
	@Column(nullable = true)
	private Date dataNascimento;
	
	public Pessoa() {}

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
	
	public Long getIdestadocivil() {
		return idestadocivil;
	}

	public void setIdestadocivil(Long idestadocivil) {
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

	public Date getDatanascimento() {
		return dataNascimento;
	}

	public void setDatanascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

		@Override
		public int hashCode() {
			return Objects.hash(cpf, dataNascimento, id, idestadocivil, nome, rgn);
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
			return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
					&& Objects.equals(id, other.id) && Objects.equals(idestadocivil, other.idestadocivil)
					&& Objects.equals(nome, other.nome) && Objects.equals(rgn, other.rgn);
		}
}
