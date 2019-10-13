package br.com.fiap.deschateie.model;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;

@Entity
@Table(name = "T_SCP_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7586472784578647213L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "nm_usuario",length = 80,nullable = false)
     private String nomeUsuario;

    @Column(name = "ds_email",nullable = false,length = 80,unique = true)
    private String email;

    @Column(name = "dt_nascimento",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataNascimento;

    @Column(name ="ds_login", nullable = false,length = 20)
    private String login;

    @Column(name = "ds_senha",nullable = false,length = 15)
    private String senha;

    @Column(name = "nr_nivel_permissao",nullable = false)
    @Enumerated(EnumType.STRING)
    private NumeroPermissao nivelPermissao;

    @Column(name = "ds_foto", length=500)
    private String foto;

    @Column(name = "ds_genero")
    private String genero;
	
	public Usuario(String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha, String foto, String genero) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.senha = senha;
        this.nivelPermissao = NumeroPermissao.P0;
        this.foto = foto;
        this.genero = genero;
    }

	
	
	public Usuario(long id, String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha,
			NumeroPermissao nivelPermissao, String foto, String genero) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.nivelPermissao = nivelPermissao;
		this.foto = foto;
		this.genero = genero;
	}
	
	public Usuario(String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha,
			NumeroPermissao nivelPermissao, String foto, String genero) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.nivelPermissao = nivelPermissao;
		this.foto = foto;
		this.genero = genero;
	}
	
	public Usuario(long id, String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha, String foto, String genero) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.nivelPermissao = NumeroPermissao.P0;
		this.foto = foto;
		this.genero = genero;
	}



	public Usuario() {
		super();
	}

	public Usuario(Usuario usuario) {
		this.nomeUsuario = usuario.getNomeUsuario();
	    this.email = usuario.getEmail();
	    this.dataNascimento = usuario.getDataNascimento();
	    this.login = usuario.getLogin();
	    this.senha = usuario.getSenha();
	    this.nivelPermissao = NumeroPermissao.P0;
	    this.foto = usuario.getFoto();
	    this.genero = usuario.getGenero();
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public NumeroPermissao getNivelPermissao() {
		return nivelPermissao;
	}

	public void setNivelPermissao(NumeroPermissao nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

    


}
