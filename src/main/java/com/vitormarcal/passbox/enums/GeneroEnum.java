package com.vitormarcal.passbox.enums;

public enum GeneroEnum {
	
	MASCULINO("Masculino"), FEMININO("Feminino");
	
	String descricao;
	
	private GeneroEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
