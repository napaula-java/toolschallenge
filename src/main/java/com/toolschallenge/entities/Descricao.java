package com.toolschallenge.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.toolschallenge.enums.TransacaoStatus;

@Embeddable
public class Descricao  {

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	
	@NotNull
	@Positive
	private BigDecimal valor;
	@NotNull
	@Size(max = 100)
	private String estabelecimento;
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long nsu;
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoAutorizacao;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TransacaoStatus transacaoStatus;
	
	
	
	public Descricao() {
		
	}



	public Descricao(Instant date, @NotNull @Positive BigDecimal valor,
			@NotNull @Size(max = 100) String estabelecimento, @NotNull Long nsu, @NotNull Long codigoAutorizacao,
			@NotNull TransacaoStatus transacaoStatus) {
		super();
		this.date = date;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
//		this.nsu = nsu;
//		this.codigoAutorizacao = codigoAutorizacao;
		this.transacaoStatus = transacaoStatus;
	}


	
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Long getNsu() {
		return nsu;
	}
	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}
	public Long getCodigoAutorizacao() {
		return codigoAutorizacao;
	}
	public void setCodigoAutorizacao(Long codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}
	public TransacaoStatus getTransacaoStatus() {
		return transacaoStatus;
	}
	public void setTransacaoStatus(TransacaoStatus transacaoStatus) {
		this.transacaoStatus = transacaoStatus;
	}
	
	
	
	
}
