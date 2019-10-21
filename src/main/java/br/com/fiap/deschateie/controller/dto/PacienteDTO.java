package br.com.fiap.deschateie.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.NumeroPermissao;
import br.com.fiap.deschateie.model.Paciente;

public class PacienteDTO {

	private Long codigo;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Genero genero;
	private String cep;
	private Long cpf;
	private String historico;
	private int consultasRealizadas;
	private NumeroPermissao numeroPermissao;

	public PacienteDTO(Paciente paciente) {
		super();
		this.codigo = paciente.getCodigo();
		this.nome = paciente.getNome();
		this.email = paciente.getEmail();
		this.dataNascimento = paciente.getDataNascimento();
		this.genero = paciente.getGenero();
		this.cep = paciente.getCep();
		this.cpf = paciente.getCpf();
		this.historico = paciente.getHistorico();
		this.consultasRealizadas = paciente.getConsultasRealizadas();
		this.numeroPermissao = paciente.getNumeroPermissao();
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public String getCep() {
		return cep;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getHistorico() {
		return historico;
	}

	public int getConsultasRealizadas() {
		return consultasRealizadas;
	}

	public NumeroPermissao getNumeroPermissao() {
		return numeroPermissao;
	}

	public static Page<PacienteDTO> converter(Page<Paciente> pacientes) {
		return pacientes.map(PacienteDTO::new);
	}
}
