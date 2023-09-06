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
import com.persistencesoft.persistence.model.TipoLancamento;
import com.persistencesoft.persistence.repository.TipoLancamentoRepository;

@RestController
@RequestMapping("/tipolancamento")
public class TipoLancamentoController {
	
	private final TipoLancamentoRepository tipoLancamentoRepository;
	
	public TipoLancamentoController(TipoLancamentoRepository tipoLancamentoRepository) {
		this.tipoLancamentoRepository = tipoLancamentoRepository;
	}
	
	@GetMapping
	public List<TipoLancamento> listar(@RequestParam String pesquisa) {
		return this.tipoLancamentoRepository.findAllByNomeContainsIgnoreCase(pesquisa);
	}
	
	@PostMapping
	public TipoLancamento salvar(@RequestBody TipoLancamento novoTipoLancamento) {
		return this.tipoLancamentoRepository.save(novoTipoLancamento);
	}
	
	@GetMapping("/{id}")
	public TipoLancamento carregar(@PathVariable Long id) {
		return this.tipoLancamentoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public TipoLancamento atualizar(@RequestBody TipoLancamento novoTipoLancamento, @PathVariable Long id) {
		return this.tipoLancamentoRepository.findById(id).map(tipoLancamento -> {
			tipoLancamento.setNome(novoTipoLancamento.getNome());
			tipoLancamento.setDescricao(novoTipoLancamento.getDescricao());
			return this.tipoLancamentoRepository.save(tipoLancamento);
		}).orElseGet(() -> {
			novoTipoLancamento.setId(id);
			return this.tipoLancamentoRepository.save(novoTipoLancamento);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.tipoLancamentoRepository.deleteById(id);
	}

}
