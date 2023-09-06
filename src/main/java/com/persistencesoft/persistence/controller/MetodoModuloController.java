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
import com.persistencesoft.persistence.model.MetodoModulo;
import com.persistencesoft.persistence.repository.MetodoModuloRepository;

@RestController
@RequestMapping("/metodomodulo")
public class MetodoModuloController {
	
	private final MetodoModuloRepository metodoModuloRepository;
	
	public MetodoModuloController(MetodoModuloRepository metodoModuloRepository) {
		this.metodoModuloRepository = metodoModuloRepository;
	}
	
	@GetMapping
	public List<MetodoModulo> listar(
		@RequestParam(required = false) Integer idMetodo,
		@RequestParam(required = false) Integer idMetodoModuloPai
	) {
		return this.metodoModuloRepository.findAllByIdMetodoAndIdMetodoModuloPai(idMetodo, idMetodoModuloPai);
	}
	
	@PostMapping
	public MetodoModulo salvar(@RequestBody MetodoModulo novoMetodoModulo) {
		return this.metodoModuloRepository.save(novoMetodoModulo);
	}
	
	@GetMapping("/{id}")
	public MetodoModulo carregar(@PathVariable Long id) {
		return this.metodoModuloRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public MetodoModulo atualizar(@RequestBody MetodoModulo novoMetodoModulo, @PathVariable Long id) {
		return this.metodoModuloRepository.findById(id).map(metodoModulo -> {
			metodoModulo.setNome(novoMetodoModulo.getNome());
			metodoModulo.setDescricao(novoMetodoModulo.getDescricao());
			metodoModulo.setIdMetodo(novoMetodoModulo.getIdMetodo());
			metodoModulo.setIdMetodoModuloPai(novoMetodoModulo.getIdMetodoModuloPai());
			return this.metodoModuloRepository.save(metodoModulo);
		}).orElseGet(() -> {
			novoMetodoModulo.setId(id);
			return this.metodoModuloRepository.save(novoMetodoModulo);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.metodoModuloRepository.deleteById(id);
	}

}
