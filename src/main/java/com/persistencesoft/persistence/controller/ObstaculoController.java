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
import com.persistencesoft.persistence.model.Obstaculo;
import com.persistencesoft.persistence.repository.ObstaculoRepository;

@RestController
@RequestMapping("/obstaculo")
public class ObstaculoController {
	
	private final ObstaculoRepository repository;

	public ObstaculoController(ObstaculoRepository obstaculoRepository) {
		this.repository = obstaculoRepository;
	}
	
	@GetMapping
	public List<Obstaculo> listar() {
		return this.repository.findAll();
	}
	
	@PostMapping
	public Obstaculo salvar(@RequestBody Obstaculo obstaculo) {
		return this.repository.save(obstaculo);
	}
	
	@GetMapping("/{id}")
	public Obstaculo carregar(@PathVariable Long id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Obstaculo atualizar(@RequestBody Obstaculo novoObstaculo, @PathVariable Long id) {
		return this.repository.findById(id).map(obstaculo -> {
			obstaculo.setNome(novoObstaculo.getNome());
			obstaculo.setComoSuperar(novoObstaculo.getComoSuperar());
			return this.repository.save(obstaculo);
		}).orElseGet(() -> {
			novoObstaculo.setId(id);
			return this.repository.save(novoObstaculo);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.repository.deleteById(id);
	}
	
}
