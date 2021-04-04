package br.com.desafio.dto;

import java.util.Date;


public class ListagemUtensilioDTO {

private long id;
	
	private String descricao;
	
	private Date dataDoacao;
	
	private String doador;

	public ListagemUtensilioDTO(long id, String descricao, Date dataDoacao, String doador) {
		this.id = id;
		this.descricao = descricao;
		this.dataDoacao = dataDoacao;
		this.doador = doador;
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


	public Date getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(Date dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public String getDoador() {
		return doador;
	}

	public void setDoador(String doador) {
		this.doador = doador;
	}
	
}
