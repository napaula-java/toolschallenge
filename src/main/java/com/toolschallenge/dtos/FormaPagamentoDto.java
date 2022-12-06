package com.toolschallenge.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.toolschallenge.enums.TipoPagamento;

public class FormaPagamentoDto {

	
@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;
@NotBlank
	@Size(min= 1, max= 2)
	private int parcelas;
	
	
	
	
	public FormaPagamentoDto(@NotBlank TipoPagamento tipoPagamento, @NotBlank @Size(min = 1, max = 2) int parcelas) {
	super();
	this.tipoPagamento = tipoPagamento;
	this.parcelas = parcelas;
}
	
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	
	
	
}
