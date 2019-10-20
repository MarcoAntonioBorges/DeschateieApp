package br.com.fiap.DeschateieDemo.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.DeschateieDemo.model.Genero;
import br.com.fiap.DeschateieDemo.model.Usuario;

public class UsuarioForm {

	@NotEmpty @NotNull @Length(max=50, min=3)
	private String nome;
	
	@NotEmpty @NotNull @Length(max=50)
	private String email;
	
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull
	private Genero genero;

	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	public UsuarioForm() {
		super();
	}

	public UsuarioForm(String nome, String email, LocalDate dataNascimento,
			Genero genero, String login, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.login = login;
		this.senha = senha;
	}

	

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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
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

	public Usuario converter() {
		return new Usuario(nome, email, dataNascimento,login, senha, genero);
	}
	
	
	
}
