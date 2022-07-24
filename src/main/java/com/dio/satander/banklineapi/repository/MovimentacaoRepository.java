package com.dio.satander.banklineapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.satander.banklineapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

	List<Movimentacao> findByIdConta(Integer idConta);
	
	

}
