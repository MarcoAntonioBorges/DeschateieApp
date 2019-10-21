package br.com.fiap.DeschateieDemo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_DES_VOLUNTARIO")
@PrimaryKeyJoinColumn(name="codigo")
public class Voluntario extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8612069103774209195L;
	
	private String rg;
	private Long cpf;
	private String formacao;
	private Periodo periodo;
	private String comentario;
	private Long telefone;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	
	public Voluntario(String rg, Long cpf, String formacao, Periodo periodo, String comentario, Long telefone) {
		super();
		this.rg = rg;
		this.cpf = cpf;
		this.formacao = formacao;
		this.periodo = periodo;
		this.comentario = comentario;
		this.telefone = telefone;
	}
	
	
	public Voluntario(String nome, String email, LocalDate dataNascimento, String login, String senha, Genero genero, String rg, Long cpf, String formacao, Periodo periodo,
			String comentario, Long telefone) {
		super(nome, email, dataNascimento, login, senha, NumeroPermissao.P3, genero);
		this.rg = rg;
		this.cpf = cpf;
		this.formacao = formacao;
		this.periodo = periodo;
		this.comentario = comentario;
		this.telefone = telefone;
	}
	public Voluntario() {
		super();
	}
	
}
