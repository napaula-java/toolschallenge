package com.toolschallenge.dtos;

import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class DescricaoDto {

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'", timezone = "GMT")
	@NotBlank
	private Instant date;
	@NotBlank
	@Positive
	private double valor;
	@NotBlank
	@Size(max = 100)
	private String estabelecimento;
	
	
	public DescricaoDto(@NotBlank Instant date, @NotBlank @Positive double valor,
			@NotBlank @Size(max = 100) String estabelecimento) {
		super();
		this.date = date;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
	}
	
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	

}
