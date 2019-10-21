package br.com.fiap.deschateie.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="T_DES_ENDERECO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7908128525075504396L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Enumerated(value = EnumType.STRING)
	private Logradouro logradouro;
	
	private String numero;
	private String complemento;
	private Long cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	@Transient
	private Evento evento;
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Evento getEvento(){
		return this.evento;
	}
	
	public Endereco(Logradouro logradouro, String numero, String complemento, Long cep, String bairro, String cidade,
			String uf, String pais, Evento evento) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.evento = evento;
	}

	public Endereco(Long codigo, Logradouro logradouro, String numero, String complemento, Long cep, String bairro,
			String cidade, String uf, String pais, Evento evento) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.evento = evento;
	}

	public Endereco(Logradouro logradouro, String numero, String complemento, Long cep, String bairro, String cidade,
			String uf, String pais) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}
	public Endereco() {
		super();
	}
	public Endereco(Long codigo, Logradouro logradouro, String numero, String complemento, Long cep, String bairro,
			String cidade, String uf, String pais) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Logradouro getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Logradouro logradouro) {
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
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
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
	
	
}
