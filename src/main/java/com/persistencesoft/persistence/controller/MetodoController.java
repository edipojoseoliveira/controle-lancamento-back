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
import com.persistencesoft.persistence.model.Metodo;
import com.persistencesoft.persistence.repository.MetodoRepository;

@RestController
@RequestMapping("/metodo")
public class MetodoController {
	
	private final MetodoRepository metodoRepository;
	
	public MetodoController(MetodoRepository tipoRepository) {
		this.metodoRepository = tipoRepository;
	}
	
	@GetMapping
	public List<Metodo> listar(@RequestParam String pesquisa) {
		return this.metodoRepository.findAllByNomeContainsIgnoreCase(pesquisa);
	}
	
	@PostMapping
	public Metodo salvar(@RequestBody Metodo novoMetodo) {
		return this.metodoRepository.save(novoMetodo);
	}
	
	@GetMapping("/{id}")
	public Metodo carregar(@PathVariable Long id) {
		return this.metodoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Metodo atualizar(@RequestBody Metodo novoMetodo, @PathVariable Long id) {
		return this.metodoRepository.findById(id).map(tipoLancamento -> {
			tipoLancamento.setNome(novoMetodo.getNome());
			return this.metodoRepository.save(tipoLancamento);
		}).orElseGet(() -> {
			novoMetodo.setId(id);
			return this.metodoRepository.save(novoMetodo);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.metodoRepository.deleteById(id);
	}

}
