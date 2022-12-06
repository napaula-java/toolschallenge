package com.toolschallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolschallenge.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	
}
