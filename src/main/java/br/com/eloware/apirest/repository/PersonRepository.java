package br.com.eloware.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eloware.apirest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
