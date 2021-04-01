package br.com.desafio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "utensilio")
@SQLDelete(sql="UPDATE utensilio SET ativo = false WHERE id = ?")
@Where(clause = "ativo = true")
public class Utensilio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descricao;
	
	private boolean disponivel;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "data_doacao", nullable = false)
	private Date dataDoacao;
	
	private boolean ativo;
	
	
	public Utensilio() {
		this.dataDoacao = new Date();
		this.ativo = true;
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
