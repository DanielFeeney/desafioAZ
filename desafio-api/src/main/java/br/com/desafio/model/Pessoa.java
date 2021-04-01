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
@Table(name = "pessoa")
@SQLDelete(sql="UPDATE pessoa SET ativo = false WHERE id = ?")
@Where(clause = "ativo = true")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;
	
	@Column(nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	private String telefone;
	
	private String celular;
	
	private String email;
	
	private boolean ativo;
	
	
	public Pessoa() {
		this.dataCadastro = new Date();
		this.ativo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
