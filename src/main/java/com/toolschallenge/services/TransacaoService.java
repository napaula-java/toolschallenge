package com.toolschallenge.services;



import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.toolschallenge.dtos.TransacaoDto;
import com.toolschallenge.entities.Transacao;
import com.toolschallenge.enums.TransacaoStatus;
import com.toolschallenge.repositories.TransacaoRepository;
import com.toolschallenge.services.exceptions.DataBaseException;
import com.toolschallenge.services.exceptions.ResourceNotFoundException;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Page<Transacao> obterTransacao(Pageable paginacao){
		return transacaoRepository
			.findAll(paginacao);
		
	}
	
	public Transacao obterTransacaoPorId(Long id){
		Transacao transacao = transacaoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		return transacao;
	}
	
	public void removerPagamento(Long id) {
		try {
	transacaoRepository.deleteById(id);
	
		} catch  (EmptyResultDataAccessException e) {
		throw new ResourceNotFoundException(id);
		
	} catch (DataIntegrityViolationException e) {
		throw new DataBaseException(e.getMessage());
			
		}
	}

	public Transacao criarPagamento(TransacaoDto dto) {
		Transacao transacao  = modelMapper.map(dto, Transacao.class);
	    transacao.getDescricao().setTransacaoStatus(TransacaoStatus.AUTORIZADO);
	    transacaoRepository.save(transacao);
		return transacao;
		
	}
	

	public Transacao atualizarStatus(Transacao transacao) {
	    transacao.getDescricao().setTransacaoStatus(TransacaoStatus.NEGADO);
	    transacaoRepository.save(transacao);
		return transacao;
}
	
}