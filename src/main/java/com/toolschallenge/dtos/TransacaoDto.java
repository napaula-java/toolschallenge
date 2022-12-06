package com.toolschallenge.dtos;



public class TransacaoDto {

    private String cartao;
    private DescricaoDto descricaoDto;
    private FormaPagamentoDto formaPagamentoDto;
    
    
	
	public TransacaoDto(String cartao, DescricaoDto descricaoDto, FormaPagamentoDto formaPagamentoDto) {
		super();
		this.cartao = cartao;
		this.descricaoDto = descricaoDto;
		this.formaPagamentoDto = formaPagamentoDto;
	}
	
	
	public FormaPagamentoDto getFormaPagamentoDto() {
		return formaPagamentoDto;
	}
	public void setFormaPagamentoDto(FormaPagamentoDto formaPagamentoDto) {
		this.formaPagamentoDto = formaPagamentoDto;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public DescricaoDto getDescricaoDto() {
		return descricaoDto;
	}
	public void setDescricaoDto(DescricaoDto descricaoDto) {
		this.descricaoDto = descricaoDto;
	}

    
    
}
