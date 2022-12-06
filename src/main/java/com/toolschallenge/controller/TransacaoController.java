package com.toolschallenge.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.toolschallenge.dtos.TransacaoDto;
import com.toolschallenge.entities.Transacao;
import com.toolschallenge.services.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	
	@Autowired
	private TransacaoService transacaoService; 
	
	@GetMapping
	public Page<Transacao> Listar(@PageableDefault(size = 10) Pageable paginacao){
		return transacaoService.obterTransacao(paginacao);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transacao>  findById(@PathVariable @NotNull Long id){
		Transacao transacao = transacaoService.obterTransacaoPorId(id);
		return ResponseEntity.ok(transacao);
	}
	
		@PostMapping
		public ResponseEntity<Transacao> pagar(@RequestBody @Valid TransacaoDto dto, UriComponentsBuilder uriBuilder) {
		    Transacao transacao = transacaoService.criarPagamento(dto);
			URI endereco = uriBuilder.path("/pagamento/{id}").buildAndExpand(transacao.getId()).toUri();
			return ResponseEntity.created(endereco).body(transacao);
			
		}
		
		@PatchMapping("/{id}")
		public ResponseEntity<Transacao> updatePartially(@PathVariable @NotNull Long id, UriComponentsBuilder uriBuilder) {
		   Transacao transacao = transacaoService.obterTransacaoPorId(id);
		   Transacao estorno = transacaoService.atualizarStatus(transacao);
		   URI endereco = uriBuilder.path("/pagamento/{id}").buildAndExpand(transacao.getId()).toUri();
		   return ResponseEntity.created(endereco).body(estorno);
			
		}
		
		
		
			

}
