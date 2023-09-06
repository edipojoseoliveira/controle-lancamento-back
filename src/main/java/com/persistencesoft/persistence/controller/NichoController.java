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
import com.persistencesoft.persistence.model.Nicho;
import com.persistencesoft.persistence.repository.NichoRepository;

@RestController
@RequestMapping("/nicho")
public class NichoController {
	
	private final NichoRepository nichoRepository;
	
	public NichoController(NichoRepository nichoRepository) {
		this.nichoRepository = nichoRepository;
	}
	
	@GetMapping
	public List<Nicho> listar(@RequestParam String pesquisa) {
		return this.nichoRepository.findAllByNomeContainsIgnoreCase(pesquisa);
	}
	
	@PostMapping
	public Nicho salvar(@RequestBody Nicho novaNicho) {
		return this.nichoRepository.save(novaNicho);
	}
	
	@GetMapping("/{id}")
	public Nicho carregar(@PathVariable Long id) {
		return this.nichoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Nicho atualizar(@RequestBody Nicho novaNicho, @PathVariable Long id) {
		return this.nichoRepository.findById(id).map(nicho -> {
			nicho.setNome(novaNicho.getNome());
			nicho.setAtivo(novaNicho.isAtivo());
			return this.nichoRepository.save(nicho);
		}).orElseGet(() -> {
			novaNicho.setId(id);
			return this.nichoRepository.save(novaNicho);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.nichoRepository.deleteById(id);
	}

}
