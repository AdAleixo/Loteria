package com.loteria.loteria.entidades;

import java.util.ArrayList;
import java.util.List;

public class JogoDTO {

	private String email;
	private List<Integer> numeros = new ArrayList<Integer>();
	private Integer idJogo;

	public Integer getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Integer idJogo) {
		this.idJogo = idJogo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}

}
