package com.dio.satander.banklineapi.service;





import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.satander.banklineapi.dto.NovaMovimentacao;
import com.dio.satander.banklineapi.model.Correntista;
import com.dio.satander.banklineapi.model.Movimentacao;
import com.dio.satander.banklineapi.model.MovimentacaoTipo;
import com.dio.satander.banklineapi.repository.CorrentistaReposiory;
import com.dio.satander.banklineapi.repository.MovimentacaoRepository;

@Service  
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaReposiory correntistaRepo;
	public void save(NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();
		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
 		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepo.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepo.save(correntista);
		}
		
		repository.save(movimentacao);
	}
}
