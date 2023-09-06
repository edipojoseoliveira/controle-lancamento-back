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
import com.persistencesoft.persistence.model.GatilhoMental;
import com.persistencesoft.persistence.repository.GatilhoMentalRepository;

/*
 * https://spring.io/guides/tutorials/rest/
 */

@RestController
@RequestMapping("/gatilhomental")
public class GatilhoMentalController {

	private final GatilhoMentalRepository gatilhoMentalRepository;

	public GatilhoMentalController(GatilhoMentalRepository gatilhoMentalRepository) {
		this.gatilhoMentalRepository = gatilhoMentalRepository;
	}

	@GetMapping
	public List<GatilhoMental> listar(@RequestParam String pesquisa) {
		return this.gatilhoMentalRepository.findAllByNomeContainsIgnoreCase(pesquisa);
	}

	@PostMapping
	public GatilhoMental salvar(@RequestBody GatilhoMental novoGatilhoMental) {
		return this.gatilhoMentalRepository.save(novoGatilhoMental);
	}

	@GetMapping("/{id}")
	public GatilhoMental carregar(@PathVariable Long id) {
		return this.gatilhoMentalRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}

	@PutMapping("/{id}")
	public GatilhoMental atualizar(@RequestBody GatilhoMental novoGatilhoMental, @PathVariable Long id) {
		return this.gatilhoMentalRepository.findById(id).map(gatilhoMental -> {
			gatilhoMental.setBeneficioDeAplicar(novoGatilhoMental.getBeneficioDeAplicar());
			gatilhoMental.setComoAplicar(novoGatilhoMental.getComoAplicar());
			gatilhoMental.setNome(novoGatilhoMental.getNome());
			gatilhoMental.setObservacao(novoGatilhoMental.getObservacao());
			gatilhoMental.setOndeAplicar(novoGatilhoMental.getOndeAplicar());
			gatilhoMental.setVisaoGeral(novoGatilhoMental.getVisaoGeral());
			return this.gatilhoMentalRepository.save(gatilhoMental);
		}).orElseGet(() -> {
			novoGatilhoMental.setId(id);
			return this.gatilhoMentalRepository.save(novoGatilhoMental);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.gatilhoMentalRepository.deleteById(id);
	}

}
