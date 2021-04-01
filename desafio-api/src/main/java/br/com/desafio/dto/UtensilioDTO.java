package br.com.desafio.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UtensilioDTO {

private long id;
	
	private String descricao;
	
	private boolean disponivel;
	
	private Date dataDoacao;

	public UtensilioDTO(long id, String descricao, boolean disponivel, Date dataDoacao) {
		this.id = id;
		this.descricao = descricao;
		this.disponivel = disponivel;
		this.dataDoacao = dataDoacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Date getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(Date dataDoacao) {
		this.dataDoacao = dataDoacao;
	}
	
	
}
