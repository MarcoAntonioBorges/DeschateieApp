package br.com.fiap.Deschateie.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.fiap.Deschateie.model.Genero;
import br.com.fiap.Deschateie.model.NumeroPermissao;
import br.com.fiap.Deschateie.model.Periodo;
import br.com.fiap.Deschateie.model.Voluntario;

public class VoluntarioDTO{

	private Long codigo;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Genero genero;
	private String rg;
	private Long cpf;
	private String formacao;
	private Periodo periodo;
	private String comentario;
	private Long telefone;
	private NumeroPermissao numeroPermissao;
	
	
	
	
	public VoluntarioDTO(Voluntario voluntario) {
		super();
		this.codigo = voluntario.getCodigo();
		this.nome = voluntario.getNome();
		this.email = voluntario.getEmail();
		this.dataNascimento = voluntario.getDataNascimento();
		this.genero = voluntario.getGenero();
		this.rg = voluntario.getRg();
		this.cpf = voluntario.getCpf();
		this.formacao = voluntario.getFormacao();
		this.periodo = voluntario.getPeriodo();
		this.comentario = voluntario.getComentario();
		this.telefone = voluntario.getTelefone();
		this.numeroPermissao = voluntario.getNumeroPermissao();
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







	public String getRg() {
		return rg;
	}







	public Long getCpf() {
		return cpf;
	}







	public String getFormacao() {
		return formacao;
	}







	public Periodo getPeriodo() {
		return periodo;
	}







	public String getComentario() {
		return comentario;
	}







	public Long getTelefone() {
		return telefone;
	}
	
	
	public NumeroPermissao getNumeroPermissao() {
		return numeroPermissao;
	}







	public static Page<VoluntarioDTO> converter(Page<Voluntario> voluntarios) {
		return voluntarios.map(VoluntarioDTO::new);
	}
}
