package br.com.fiap.DeschateieDemo.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.DeschateieDemo.model.Genero;
import br.com.fiap.DeschateieDemo.model.Paciente;

public class PacienteForm {

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

	@Length(max = 20)
	private String cep;

	@NotNull
	private Long cpf;

	@Length(max = 500)
	private String historico;

	private int consultasRealizadas;

	public PacienteForm(String nome, String email, LocalDate dataNascimento, String login, String senha,
			Genero genero, String cep, Long cpf, String historico, int consultasRealizadas) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.genero = genero;
		this.cep = cep;
		this.cpf = cpf;
		this.historico = historico;
		this.consultasRealizadas = consultasRealizadas;
	}

	public PacienteForm() {
		super();
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getConsultasRealizadas() {
		return consultasRealizadas;
	}

	public void setConsultasRealizadas(int consultasRealizadas) {
		this.consultasRealizadas = consultasRealizadas;
	}

	public Paciente converter() {
		return new Paciente(nome, email, dataNascimento, login, senha, genero, cep, cpf, historico,
				consultasRealizadas);
	}
}
