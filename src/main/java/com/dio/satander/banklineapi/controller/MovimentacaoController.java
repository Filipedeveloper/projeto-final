package com.dio.satander.banklineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.satander.banklineapi.dto.NovaMovimentacao;
import com.dio.satander.banklineapi.dto.NovoCorrentista;
import com.dio.satander.banklineapi.model.Correntista;
import com.dio.satander.banklineapi.model.Movimentacao;
import com.dio.satander.banklineapi.repository.CorrentistaReposiory;
import com.dio.satander.banklineapi.repository.MovimentacaoRepository;
import com.dio.satander.banklineapi.service.CorrentistaService;
import com.dio.satander.banklineapi.service.MovimentacaoService;

@RestController

public class MovimentacaoController {
	@Autowired 
	private MovimentacaoRepository repo;
	
	@Autowired
	private MovimentacaoService service;

	@RequestMapping("/movimentacoes")
	public List<Movimentacao> findAll(){
		return repo.findAll();
	}
	
	@RequestMapping("/movimentacoes/{idConta}")
	public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
		return repo.findByIdConta(idConta);
		
	}
	
	
	@PostMapping("/movimentacoes")
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		
		service.save(movimentacao);
		
	}

}
