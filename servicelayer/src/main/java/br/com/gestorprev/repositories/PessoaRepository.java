package br.com.gestorprev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestorprev.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
