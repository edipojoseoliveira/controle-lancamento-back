package com.persistencesoft.persistence.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.persistencesoft.persistence.exception.ObjectNotFoundException;
import com.persistencesoft.persistence.model.SubNicho;
import com.persistencesoft.persistence.repository.SubNichoRepository;

@RestController
@RequestMapping("/subnicho")
public class SubNichoController {
	
	private final SubNichoRepository subNichoRepository;
	
	public SubNichoController(SubNichoRepository subNichoRepository) {
		this.subNichoRepository = subNichoRepository;
	}
	
	@GetMapping
	public List<SubNicho> listar(@RequestParam String pesquisa) {
		return this.subNichoRepository.findAllByNomeContainsIgnoreCase(pesquisa);
	}
	
	@PostMapping
	public SubNicho salvar(@RequestBody SubNicho novaSubNicho) {
		return this.subNichoRepository.save(novaSubNicho);
	}
	
	@GetMapping("/{id}")
	public SubNicho carregar(@PathVariable Long id) {
		return this.subNichoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public SubNicho atualizar(@RequestBody SubNicho novoSubNicho, @PathVariable Long id) {
		return this.subNichoRepository.findById(id).map(subNicho -> {
			subNicho.setNome(novoSubNicho.getNome());
			subNicho.setTipo(novoSubNicho.getTipo());
			subNicho.setResultadoDoExpert(novoSubNicho.isResultadoDoExpert());
			subNicho.setResultadoDeClientes(novoSubNicho.isResultadoDeClientes());
			subNicho.setPessoasPedindoProduto(novoSubNicho.isPessoasPedindoProduto());
			subNicho.setAtivo(novoSubNicho.isAtivo());
			return this.subNichoRepository.save(subNicho);
		}).orElseGet(() -> {
			novoSubNicho.setId(id);
			return this.subNichoRepository.save(novoSubNicho);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.subNichoRepository.deleteById(id);
	}

}
