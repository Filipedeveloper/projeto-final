package com.dio.satander.banklineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.satander.banklineapi.dto.NovoCorrentista;
import com.dio.satander.banklineapi.model.Correntista;
import com.dio.satander.banklineapi.repository.CorrentistaReposiory;
import com.dio.satander.banklineapi.service.CorrentistaService;

@RestController

public class CorrentistaController {
	@Autowired 
	private CorrentistaReposiory repo;
	
	@Autowired
	private CorrentistaService service;

	@RequestMapping("/correntistas")
	public List<Correntista> findAll(){
		return repo.findAll();
	}
	
	
	@PostMapping("/correntistas")
	public void save(@RequestBody NovoCorrentista corre) {
		
		service.save(corre);
		
	}

}
