package br.com.fiap.deschateie.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_SCP_VOLUNTARIO")
@PrimaryKeyJoinColumn(name = "cd_usuario")
public class Voluntario extends  Usuario{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6437730120001130765L;

	@Column(name = "nr_rg",length = 255,nullable = false,unique = true)
    private String rg;

    @Column(name = "nr_cpf",length = 255,nullable = false,unique = true)
    private long cpf;

    @Column(name = "ds_formacao",length = 60,nullable = false)
    private String formacao;

    @Column(name = "ds_periodo",length = 40,nullable = false)
    private String periodo;

    @Column(name = "ds_comentario",length = 80,nullable = false)
    private String comentario;

    @Column(name = "ds_telefone",length = 11,nullable = false)
    private long telefone;
    
    @OneToOne(mappedBy="voluntario")
    @JoinColumn(name="cd_endereco")
    private Endereco endereco;

	public Voluntario(String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha,
			String foto, String genero, String rg, long cpf, String formacao, String periodo, String comentario,
			long telefone) {
		super(nomeUsuario, email, dataNascimento, login, senha, foto, genero);
		this.rg = rg;
		this.cpf = cpf;
		this.formacao = formacao;
		this.periodo = periodo;
		this.comentario = comentario;
		this.telefone = telefone;
	}

	public Voluntario() {
		super();
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
    
    
}
