package br.com.fiap.deschateie.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_SCP_PSICOLOGO")
@PrimaryKeyJoinColumn(name = "cd_usuario")
public class Psicologo extends  Usuario{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -279587444174450354L;

	@Column(name = "nr_crp",length = 7,nullable = false,unique = true)
    private int numeroCrp;

    @Column(name = "ds_formacao",length = 40,nullable = false)
    private String formacao;

    @Column(name = "ds_biografia",length = 120)
    private String biografia;

    @Column(name = "ds_telefone",nullable = false,length = 11)
    private long telefone;

    @Column(name = "vl_consulta",length = 6)
    private double valorConsulta;

    @OneToMany(mappedBy="psicologo")
    private List<Endereco> endereco;

    
	public Psicologo() {
		super();
	}

	public Psicologo(String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha,
			String foto, String genero, int numeroCrp, String formacao, String biografia, long telefone,
			double valorConsulta, List<Endereco> endereco) {
		super(nomeUsuario, email, dataNascimento, login, senha, foto, genero);
		this.numeroCrp = numeroCrp;
		this.formacao = formacao;
		this.biografia = biografia;
		this.telefone = telefone;
		this.valorConsulta = valorConsulta;
		this.endereco = endereco;
	}

	public int getNumeroCrp() {
		return numeroCrp;
	}

	public void setNumeroCrp(int numeroCrp) {
		this.numeroCrp = numeroCrp;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
    
    
}
