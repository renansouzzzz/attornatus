package br.com.eloware.apirest.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eloware.apirest.model.Pessoa;
import br.com.eloware.apirest.repository.PessoaRepository;

@Service
public class PessoaServico {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa editarPessoa(Long id, Pessoa pessoa) {
		
		Pessoa novaPessoa = repository.findById(id).get();
		novaPessoa.setNome(pessoa.getNome());
		novaPessoa.setDataNascimento(pessoa.getDataNascimento());
		novaPessoa.setEndereco(pessoa.getEndereco());
		return repository.save(novaPessoa);
	}
	
	public Object criarEndereco(Long id, Pessoa pessoa) {
		
		Pessoa novaPessoa = repository.findById(id).get();
		novaPessoa.setEndereco(pessoa.getEndereco());
			return novaPessoa.getEndereco();
	}
	
	public Object listarEnderecos(Long id, Pessoa pessoa) {
		Pessoa pessoaEndereco = repository.findById(id).get();
		return pessoaEndereco.getEndereco();
	}
	
	
}
