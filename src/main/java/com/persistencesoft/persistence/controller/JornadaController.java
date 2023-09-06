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
import com.persistencesoft.persistence.model.Jornada;
import com.persistencesoft.persistence.repository.JornadaRepository;

@RestController
@RequestMapping("/jornada")
public class JornadaController {
	
	private final JornadaRepository jornadaRepository;
	
	public JornadaController(JornadaRepository jornadaRepository) {
		this.jornadaRepository = jornadaRepository;
	}
	
	@GetMapping
	public List<Jornada> listar() {
		return this.jornadaRepository.findAll();
	}
	
	@PostMapping
	public Jornada salvar(@RequestBody Jornada jornada) {
		return this.jornadaRepository.save(jornada);
	}
	
	@GetMapping("/{id}")
	public Jornada carregar(@PathVariable Long id) {
		return this.jornadaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public Jornada atualizar(@RequestBody Jornada novaJornada, @PathVariable Long id) {
		return this.jornadaRepository.findById(id).map(jornada -> {
			jornada.setNome(novaJornada.getNome());
			jornada.setMarcos(novaJornada.getMarcos());
			return this.jornadaRepository.save(jornada);
		}).orElseGet(() -> {
			novaJornada.setId(id);
			return this.jornadaRepository.save(novaJornada);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.jornadaRepository.deleteById(id);
	}


}
