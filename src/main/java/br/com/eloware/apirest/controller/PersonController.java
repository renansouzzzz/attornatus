package br.com.eloware.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eloware.apirest.model.Address;
import br.com.eloware.apirest.model.Person;
import br.com.eloware.apirest.repository.PersonRepository;
import br.com.eloware.apirest.services.PersonService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonService service;
	
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		
		return ResponseEntity.accepted().body(repository.save(person));
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPerson(){
		
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> editPerson(@PathVariable Long id, @RequestBody Person person) {
		
		return ResponseEntity.ok().body(service.editPerson(id, person));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(repository.findById(id).get());
	}
	
	@PostMapping("/create-address/{id}")
	public ResponseEntity<Object> criarEndereco(@PathVariable Long id, @RequestBody Person person) {
		
		return ResponseEntity.accepted().body(service.createAddress(id, person));
	}
	
	@GetMapping("/list-address/{id}")
	public ResponseEntity<List<Address>> listAddressById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(service.findAddressById(id));
	}
	
	@GetMapping("/principal-address/{id}")
	public ResponseEntity<Object> principalAddressById(@PathVariable Long id){
		
		return ResponseEntity.ok().body(service.principalAddressById(id));
	}
}
