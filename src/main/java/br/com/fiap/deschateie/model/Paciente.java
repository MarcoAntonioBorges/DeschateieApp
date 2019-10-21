package br.com.fiap.deschateie.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_DES_PACIENTE")
@PrimaryKeyJoinColumn(name="codigo")
public class Paciente extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4422308499843525341L;
	private String cep;
	private Long  cpf;
	private String historico;
	private int consultasRealizadas;
	
	
	
	public Paciente() {
		super();
	}

	
	public Paciente(String nome, String email, LocalDate dataNascimento, String login, String senha,
			NumeroPermissao numeroPermissao, Genero genero, String cep, Long cpf, String historico,
			int consultasRealizadas) {
		super(nome, email, dataNascimento, login, senha, numeroPermissao, genero);
		this.cep = cep;
		this.cpf = cpf;
		this.historico = historico;
		this.consultasRealizadas = consultasRealizadas;
	}



	public Paciente(String nome, String email, LocalDate dataNascimento, String login, String senha, Genero genero,
			String cep, Long cpf, String historico, int consultasRealizadas) {
		super(nome, email, dataNascimento, login, senha, NumeroPermissao.P1, genero);
		this.cep = cep;
		this.cpf = cpf;
		this.historico = historico;
		this.consultasRealizadas = consultasRealizadas;
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
	
	
	
	
}
