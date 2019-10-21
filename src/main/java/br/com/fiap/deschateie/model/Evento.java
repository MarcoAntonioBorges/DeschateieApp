package br.com.fiap.deschateie.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_DES_EVENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1152230274297454040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private Boolean isGratuito;
	private Long capacidade;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String descricao;

	@Enumerated(value = EnumType.STRING)
	private Tipo tipo;
	private String foto;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsGratuito() {
		return isGratuito;
	}

	public void setIsGratuito(Boolean isGratuito) {
		this.isGratuito = isGratuito;
	}

	public Long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Evento(String nome, Boolean isGratuito, Long capacidade, LocalDate dataInicio, LocalDate dataFim,
			String descricao, Tipo tipo, String foto) {
		super();
		this.nome = nome;
		this.isGratuito = isGratuito;
		this.capacidade = capacidade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.tipo = tipo;
		this.foto = foto;
	}

	public Evento(Long codigo, String nome, Boolean isGratuito, Long capacidade, LocalDate dataInicio,
			LocalDate dataFim, String descricao, Tipo tipo, String foto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.isGratuito = isGratuito;
		this.capacidade = capacidade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.tipo = tipo;
		this.foto = foto;
	}

	public Evento() {
		super();
	}

	
	public Evento(String nome, Boolean isGratuito, Long capacidade, LocalDate dataInicio, LocalDate dataFim,
			String descricao, Tipo tipo, String foto, Endereco endereco) {
		super();
		this.nome = nome;
		this.isGratuito = isGratuito;
		this.capacidade = capacidade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.tipo = tipo;
		this.foto = foto;
		this.endereco = endereco;
	}

	public Evento(Long codigo, String nome, Boolean isGratuito, Long capacidade, LocalDate dataInicio,
			LocalDate dataFim, String descricao, Tipo tipo, String foto, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.isGratuito = isGratuito;
		this.capacidade = capacidade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.tipo = tipo;
		this.foto = foto;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
