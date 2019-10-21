package br.com.fiap.Deschateie.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.Deschateie.model.Genero;
import br.com.fiap.Deschateie.model.Periodo;
import br.com.fiap.Deschateie.model.Voluntario;

public class VoluntarioForm {

	@NotEmpty
	@Length(max = 50, min = 3)
	private String nome;

	@NotEmpty
	@Length(max = 50)
	private String email;

	@NotNull
	private LocalDate dataNascimento;

	@NotEmpty
	private String login;
	
	@NotEmpty
	private String senha;
	
	@NotNull
	private Genero genero;
	
	@NotNull
	private String rg;
	
	@NotNull
	private Long cpf;

	@NotNull @Length(max = 50)
	private String formacao;
	
	@NotNull
	private Periodo periodo;
	
	@Length(max = 500)
	private String comentario;
	
	@NotNull
	private Long telefone;
	

	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public LocalDate getDataNascimento() {
		return dataNascimento;
	}




	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public Genero getGenero() {
		return genero;
	}




	public void setGenero(Genero genero) {
		this.genero = genero;
	}




	public String getRg() {
		return rg;
	}




	public void setRg(String rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}




	public void setRg(Long cpf) {
		this.cpf = cpf;
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




	public Voluntario converter() {
		return new Voluntario(nome, email, dataNascimento, login, senha, genero, rg, cpf, formacao, periodo, comentario, telefone);
	}

}
