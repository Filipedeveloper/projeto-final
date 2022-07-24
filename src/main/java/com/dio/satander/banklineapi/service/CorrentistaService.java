package com.dio.satander.banklineapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.satander.banklineapi.dto.NovoCorrentista;
import com.dio.satander.banklineapi.model.Conta;
import com.dio.satander.banklineapi.model.Correntista;
import com.dio.satander.banklineapi.repository.CorrentistaReposiory;

@Service
public class CorrentistaService {

	@Autowired
	CorrentistaReposiory repository;
	public void save (NovoCorrentista novoCorrentista) {
		Correntista corre = new Correntista();
		corre.setCpf(novoCorrentista.getCpf());
		corre.setNome(novoCorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(150.00);
		conta.setNumero(new Date().getTime());
		
		corre.setConta(conta);
		
		repository.save(corre);
	}
}
