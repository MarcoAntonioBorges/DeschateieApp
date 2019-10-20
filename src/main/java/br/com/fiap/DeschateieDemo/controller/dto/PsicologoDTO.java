package br.com.fiap.DeschateieDemo.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.fiap.DeschateieDemo.model.Genero;
import br.com.fiap.DeschateieDemo.model.NumeroPermissao;
import br.com.fiap.DeschateieDemo.model.Psicologo;

public class PsicologoDTO {
//    "codigo": 1,
//    "nome": "Marco Antonio Oliveira",
//    "email": "marco@email.com",
//    "dataNascimento": "2000-03-30T05:45:12",
//    "login": "marco",
//    "senha": "123",
//    "numeroPermissao": "P0",
//    "genero": "MASCULINO",
//    "crp": 111,
//    "formacao": "PSICOLOGIA OCIDENTAL",
//    "biografia": "Jovem de 19 anos psicologo desde da infancia",
//    "telefone": 11993949612,
//    "valorConsulta": 300.0
	private Long codigo;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Genero genero;
	private Long crp;
	private String formacao;
	private String biografia;
	private Long telefone;
	private Double valorConsulta;
	private NumeroPermissao numeroPermissao;

	public PsicologoDTO(Psicologo psicologo) {
		super();
		this.codigo = psicologo.getCodigo();
		this.nome = psicologo.getNome();
		this.email = psicologo.getEmail();
		this.dataNascimento = psicologo.getDataNascimento();
		this.genero = psicologo.getGenero();
		this.crp = psicologo.getCrp();
		this.formacao = psicologo.getFormacao();
		this.biografia = psicologo.getBiografia();
		this.telefone = psicologo.getTelefone();
		this.valorConsulta = psicologo.getValorConsulta();
		this.numeroPermissao = psicologo.getNumeroPermissao();
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

	public Long getCrp() {
		return crp;
	}

	public String getFormacao() {
		return formacao;
	}

	public String getBiografia() {
		return biografia;
	}

	public Long getTelefone() {
		return telefone;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public NumeroPermissao getNumeroPermissao() {
		return numeroPermissao;
	}

	public static Page<PsicologoDTO> converter(Page<Psicologo> psicologos) {
		return psicologos.map(PsicologoDTO::new);
	}
}
