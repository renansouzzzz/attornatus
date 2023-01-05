package br.com.eloware.apirest.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eloware.apirest.model.Pessoa;
import br.com.eloware.apirest.repository.PessoaRepository;
import br.com.eloware.apirest.servicos.PessoaServico;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaServico servico;
	
	@PostMapping
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public Pessoa editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return servico.editarPessoa(id, pessoa);
	}
	
	@GetMapping("/{id}")
	public Pessoa buscarPessoa(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	@PostMapping("/criarendereco/{id}")
	public Object criarEndereco(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return servico.criarEndereco(id, pessoa);
	}
	
	@GetMapping("/listarenderecos/{id}")
	public Object listarEnderecos(@PathVariable Long id, Pessoa pessoa) {
		return servico.listarEnderecos(id, pessoa);
	}
}
