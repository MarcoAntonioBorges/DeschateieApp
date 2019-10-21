package br.com.fiap.Deschateie.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.Deschateie.model.Genero;
import br.com.fiap.Deschateie.model.Periodo;
import br.com.fiap.Deschateie.model.Voluntario;
import br.com.fiap.Deschateie.repository.VoluntarioRepository;

public class AtualizacaoVoluntarioForm {

	
	@NotNull @NotEmpty @Length(max=50, min=3)
	private String nome;
	
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull
	private Genero genero;
	
	@NotNull @Length(max = 50)
	private String formacao;
	
	@NotNull 
	private Periodo periodo;
	
	@NotNull
	private Long telefone;
	
	
	
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





	public Long getTelefone() {
		return telefone;
	}





	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}





	public Voluntario atualizar(Long codigo,
			VoluntarioRepository voluntarioRepository) {
		Voluntario voluntario = voluntarioRepository.getOne(codigo);
		
		voluntario.setNome(this.nome);
		voluntario.setDataNascimento(this.dataNascimento);
		voluntario.setGenero(this.genero);
		voluntario.setFormacao(this.formacao);
		voluntario.setPeriodo(this.periodo);
		voluntario.setTelefone(this.telefone);
		
		
		return voluntario;
	}
	
	
	
}
