package br.com.fiap.deschateie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "T_SCP_ENDERECO")
@Data
@SequenceGenerator(name = "cd_endereco",sequenceName = "SQ_ENDERECO",allocationSize = 1)
public class Endereco {
    @Id
    @Column(name = "cd_endereco")
    @GeneratedValue(generator = "cd_endereco",strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ds_tipo",length = 20,nullable = false)
    private String tipo;

    @Column(name = "ds_logradouro",length = 60,nullable = false)
    private String logradouro;

    @Column(name = "nr_numero",length = 10,nullable = false)
    private String numero;

    @Column(name = "ds_complemento", length = 10)
    private String complemento;

    @Column(name = "nr_cep",length = 8,nullable = false)
    private String cep;

    @Column(name = "ds_bairro", length = 30,nullable = false)
    private String bairro;

    @Column(name = "ds_cidade",length = 30,nullable = false)
    private String cidade;

    @Column(name = "ds_uf",length = 2,nullable = false)
    private String uf;

    @Column(name = "ds_pais", length = 20, nullable = false)
    private String pais;

    @ManyToOne
    @JoinColumn(name="cd_usuario")
    private Psicologo psicologo;


    @OneToOne
    private Voluntario voluntario;
    
    @OneToOne
    @JoinColumn(name="cd_evento")
    private Evento evento;


	public Endereco(long id, String tipo, String logradouro, String numero, String complemento, String cep,
			String bairro, String cidade, String uf, String pais, Psicologo psicologo, Voluntario voluntario) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.psicologo = psicologo;
		this.voluntario = voluntario;
	}


	public Endereco() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Psicologo getPsicologo() {
		return psicologo;
	}


	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}


	public Voluntario getVoluntario() {
		return voluntario;
	}


	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
    
    


}
