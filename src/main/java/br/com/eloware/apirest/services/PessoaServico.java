package br.com.eloware.apirest.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eloware.apirest.model.Endereco;
import br.com.eloware.apirest.model.Pessoa;
import br.com.eloware.apirest.repository.PessoaRepository;

@Service
public class PessoaServico {
	
	@Autowired
	private PessoaRepository repository;
	@Test
	public Pessoa editarPessoa(Long id, Pessoa pessoa) {
		
		Pessoa novaPessoa = repository.findById(id).get();
		novaPessoa.setNome(pessoa.getNome());
		novaPessoa.setDataNascimento(pessoa.getDataNascimento());
		novaPessoa.setEndereco(pessoa.getEndereco());
		repository.save(novaPessoa);
			return pessoa;
	}
	@Test
	public Object criarEndereco(Long id, Pessoa pessoa) {
		
		Pessoa novaPessoa = repository.findById(id).get();
		novaPessoa.setEndereco(pessoa.getEndereco());
		repository.save(novaPessoa);
			return pessoa;
	}
	@Test
	public List<Endereco> listarEnderecos(Long id) {
		
		Pessoa pessoa = repository.findById(id).get();
			return pessoa.getEndereco();
	}
	@Test
	public Endereco informarEnderecoPrincipal(Long id) {
			
		Pessoa pessoa = repository.findById(id).get();
		Endereco enderecoPrincipal = pessoa.getEndereco().get(0);
			return enderecoPrincipal;
	}
}
