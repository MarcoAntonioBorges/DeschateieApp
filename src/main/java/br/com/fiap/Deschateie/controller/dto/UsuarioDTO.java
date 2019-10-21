package br.com.fiap.Deschateie.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.fiap.Deschateie.model.Genero;
import br.com.fiap.Deschateie.model.NumeroPermissao;
import br.com.fiap.Deschateie.model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private Genero genero;
	private NumeroPermissao numeroPermissao;
	private LocalDate dataNascimento;
	
	
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getCodigo();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.genero = usuario.getGenero();
		this.numeroPermissao = usuario.getNumeroPermissao();
		this.dataNascimento = usuario.getDataNascimento();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Genero getGenero() {
		return genero;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public NumeroPermissao getNumeroPermissao() {
		return numeroPermissao;
	}
	public void setNumeroPermissao(NumeroPermissao numeroPermissao) {
		this.numeroPermissao = numeroPermissao;
	}

	public static Page<UsuarioDTO> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDTO::new);
	}
}
