package com.persistencesoft.persistence.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistencesoft.persistence.exception.ObjectNotFoundException;
import com.persistencesoft.persistence.model.Principio;
import com.persistencesoft.persistence.repository.PrincipioRepository;

@RestController
@RequestMapping("/principio")
public class PrincipioController {
	
	private final PrincipioRepository principioRepository;
	
	public PrincipioController(PrincipioRepository principioRepository) {
		this.principioRepository = principioRepository;
	}
	
	@GetMapping
	public List<Principio> listar() {
		return this.principioRepository.findAll();
	}
	
	@PostMapping
	public Principio salvar(@RequestBody Principio principio) {
		return this.principioRepository.save(principio);
	}
	
	@GetMapping("/{id}")
	public Principio carregar(@PathVariable Long id) {
		return this.principioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Principio atualizar(@RequestBody Principio novoPrincipio, @PathVariable Long id) {
		return this.principioRepository.findById(id).map(principio -> {
			principio.setNome(novoPrincipio.getNome());
			principio.setDescricao(novoPrincipio.getDescricao());
			return this.principioRepository.save(principio);
		}).orElseGet(() -> {
			novoPrincipio.setId(id);
			return this.principioRepository.save(novoPrincipio);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.principioRepository.deleteById(id);
	}

}
