package com.toolschallenge.entities;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.toolschallenge.enums.TipoPagamento;

@Embeddable
public class FormaPagamento {

	
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;
	@NotNull
	@Size(min= 1, max= 2)
	private int parcelas;
	
	
	public FormaPagamento() {
		super();
	}
	
	public FormaPagamento(TipoPagamento tipoPagamento, @NotNull @Size(min = 1, max = 2) int parcelas) {
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
	