package br.com.fiap.deschateie.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Usuario;

public class UsuarioAutenticar {

	@NotEmpty @NotNull @Length(max=50)
	private String email;

	@NotNull
	private String senha;
	
	public UsuarioAutenticar() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioAutenticar(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public boolean autenticar(Usuario usuarioEncontrado) {
		if(this.email.equals(usuarioEncontrado.getEmail()) && this.senha.equals(usuarioEncontrado.getSenha())) {
			return true;
		}
		return false;
	}
	
}
