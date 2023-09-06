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
import com.persistencesoft.persistence.model.QuestionarioRaioX;
import com.persistencesoft.persistence.repository.QuestionarioRaioXRepository;

@RestController
@RequestMapping("/questionarioraiox")
public class QuestionarioRaioXController {
	
	private final QuestionarioRaioXRepository questionarioRaioXRepository;
	
	public QuestionarioRaioXController(QuestionarioRaioXRepository questionarioRaioXRepository) {
		this.questionarioRaioXRepository = questionarioRaioXRepository;
	}
	
	@GetMapping
	public List<QuestionarioRaioX> listar(@RequestParam String pesquisa) {
		return this.questionarioRaioXRepository.findAllByPerguntaContainsIgnoreCase(pesquisa);
	}
	
	@PostMapping
	public QuestionarioRaioX salvar(@RequestBody QuestionarioRaioX novoQuestionarioRaioX) {
		return this.questionarioRaioXRepository.save(novoQuestionarioRaioX);
	}
	
	@GetMapping("/{id}")
	public QuestionarioRaioX carregar(@PathVariable Long id) {
		return this.questionarioRaioXRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	public QuestionarioRaioX atualizar(@RequestBody QuestionarioRaioX novoQuestionarioRaioX, @PathVariable Long id) {
		return this.questionarioRaioXRepository.findById(id).map(questionarioRaioX -> {
			questionarioRaioX.setPergunta(novoQuestionarioRaioX.getPergunta());
			questionarioRaioX.setResposta(novoQuestionarioRaioX.getResposta());
			return this.questionarioRaioXRepository.save(questionarioRaioX);
		}).orElseGet(() -> {
			novoQuestionarioRaioX.setId(id);
			return this.questionarioRaioXRepository.save(novoQuestionarioRaioX);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.questionarioRaioXRepository.deleteById(id);
	}

}
