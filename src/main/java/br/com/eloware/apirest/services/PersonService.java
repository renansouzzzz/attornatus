package br.com.eloware.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eloware.apirest.model.Address;
import br.com.eloware.apirest.model.Person;
import br.com.eloware.apirest.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Person editPerson(Long id, Person person) {
		
		Person newPerson = repository.findById(id).get();
		
		newPerson.setName(person.getName());
		newPerson.setBirthDate(person.getBirthDate());
		newPerson.setAddress(person.getAddress());
		
		repository.save(newPerson);
		
			return newPerson;
	}
	
	public Object createAddress(Long id, Person person) {
		
		Person newPerson = repository.findById(id).get();
		newPerson.setAddress(person.getAddress());
		repository.save(newPerson);
		
			return newPerson;
	}
	
	public List<Address> findAddressById(Long id) {
		
		Person person = repository.findById(id).get();
		
			return person.getAddress();
	}
	
	public Address principalAddressById(Long id) {
			
		Person person = repository.findById(id).get();
		Address principalAddress = person.getAddress().get(0);
		
			return principalAddress;
	}
}
