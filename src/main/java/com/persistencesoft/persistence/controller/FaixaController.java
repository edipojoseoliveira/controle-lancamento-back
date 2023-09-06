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
import com.persistencesoft.persistence.model.Faixa;
import com.persistencesoft.persistence.repository.FaixaRepository;

@RestController
@RequestMapping("/faixa")
public class FaixaController {
	
	private final FaixaRepository faixaRepository;
	
	public FaixaController(FaixaRepository faixaRepository) {
		this.faixaRepository = faixaRepository;
	}
	
	@GetMapping
	public List<Faixa> listar(@RequestParam String pesquisa) {
		return this.faixaRepository.findAllByNomeContainsIgnoreCase(pesquisa);
	}
	
	@PostMapping
	public Faixa salvar(@RequestBody Faixa novaFaixa) {
		return this.faixaRepository.save(novaFaixa);
	}
	
	@GetMapping("/{id}")
	public Faixa carregar(@PathVariable Long id) {
		return this.faixaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Faixa atualizar(@RequestBody Faixa novaFaixa, @PathVariable Long id) {
		return this.faixaRepository.findById(id).map(faixa -> {
			faixa.setNome(novaFaixa.getNome());
			faixa.setDescricao(novaFaixa.getDescricao());
			return this.faixaRepository.save(faixa);
		}).orElseGet(() -> {
			novaFaixa.setId(id);
			return this.faixaRepository.save(novaFaixa);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.faixaRepository.deleteById(id);
	}

}
