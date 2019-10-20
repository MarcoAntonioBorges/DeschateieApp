package br.com.fiap.DeschateieDemo.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.DeschateieDemo.model.Genero;
import br.com.fiap.DeschateieDemo.model.Usuario;
import br.com.fiap.DeschateieDemo.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	@NotNull @NotEmpty @Length(max=50, min=3)
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Genero genero;
	
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

	public Usuario atualizar(Long codigo, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(codigo);
	
		usuario.setNome(this.nome);
		usuario.setDataNascimento(this.dataNascimento);
		usuario.setGenero(this.genero);
		
		return usuario;
	}

}
