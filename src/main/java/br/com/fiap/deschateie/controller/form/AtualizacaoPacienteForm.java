package br.com.fiap.deschateie.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.Paciente;
import br.com.fiap.deschateie.repository.PacienteRepository;

public class AtualizacaoPacienteForm {

	
	@NotNull @NotEmpty @Length(max=50, min=3)
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Genero genero;
	
	@Length(max = 20)
	private String cep;

	@Length(max = 500)
	private String historico;

	private int consultasRealizadas;
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
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



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
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



	public Paciente atualizar(Long codigo,
			PacienteRepository pacienteRepository) {
		Paciente paciente = pacienteRepository.getOne(codigo);
		
		paciente.setNome(this.nome);
		paciente.setDataNascimento(this.dataNascimento);
		paciente.setGenero(this.genero);
		paciente.setCep(this.cep);
		paciente.setHistorico(this.historico);
		paciente.setConsultasRealizadas(this.consultasRealizadas);
		
		return paciente;
	}
	
	
	
}
