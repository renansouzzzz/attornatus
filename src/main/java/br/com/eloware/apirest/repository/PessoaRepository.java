package br.com.eloware.apirest.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eloware.apirest.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}
