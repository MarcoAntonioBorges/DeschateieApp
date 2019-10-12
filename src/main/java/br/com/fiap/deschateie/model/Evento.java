package br.com.fiap.deschateie.model;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_SCP_EVENTO")
@SequenceGenerator(name = "cd_evento",sequenceName = "SQ_T_SCP_EVENTO",allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {

	@Id
	@GeneratedValue(generator="cd_evento", strategy=GenerationType.IDENTITY)
	private long codigo;
	
	@Column(name="nr_capacidade_inicio", nullable=false)
	private int capacidadeInicio;
	
	@Column(name="nr_capacidade_max", nullable=false)
	private int capacidadeMax;
	
	@Column(name="nm_categoria", nullable=false)
	@Enumerated(value=EnumType.STRING)
	private Categoria categoria;
	
	@Column(name="dt_inicio", nullable=false)
	private LocalDate dataInicio;
	
	@Column(name="dt_fim", nullable=false)
	private LocalDate dataFim;
	
	@Column(name="ds_evento", length=500, nullable=false)
	private String descricao;
	
	@Column(name="ds_gratuito", nullable=false)
	private boolean isGratuito;
	
	@Column(name="ds_imagem", nullable=false)
	private String imagem;
	
	@Column(name="nr_latitude", nullable=false)
	private double latitude;
	
	@Column(name="nr_longitude", nullable=false)
	private double longitude;
	
	@Column(name="nm_evento", nullable=false)
	private String nome;
	
	@OneToOne(mappedBy="evento")
	private Endereco endereco;
	
	
	public Evento() {
		super();
	}


	public Evento(long codigo, int capacidadeInicio, int capacidadeMax, Categoria categoria, LocalDate dataInicio,
			LocalDate dataFim, String descricao, boolean isGratuito, String imagem, double latitude, double longitude,
			String nome, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.capacidadeInicio = capacidadeInicio;
		this.capacidadeMax = capacidadeMax;
		this.categoria = categoria;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.isGratuito = isGratuito;
		this.imagem = imagem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	


	public Evento(int capacidadeInicio, int capacidadeMax, Categoria categoria, LocalDate dataInicio, LocalDate dataFim,
			String descricao, boolean isGratuito, String imagem, double latitude, double longitude, String nome,
			Endereco endereco) {
		super();
		this.capacidadeInicio = capacidadeInicio;
		this.capacidadeMax = capacidadeMax;
		this.categoria = categoria;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.isGratuito = isGratuito;
		this.imagem = imagem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nome = nome;
		this.endereco = endereco;
	}


	public Evento(int capacidadeInicio, int capacidadeMax, Categoria categoria, LocalDate dataInicio, LocalDate dataFim,
			String descricao, boolean isGratuito, String imagem, double latitude, double longitude, String nome) {
		super();
		this.capacidadeInicio = capacidadeInicio;
		this.capacidadeMax = capacidadeMax;
		this.categoria = categoria;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.isGratuito = isGratuito;
		this.imagem = imagem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nome = nome;
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public int getCapacidadeInicio() {
		return capacidadeInicio;
	}


	public void setCapacidadeInicio(int capacidadeInicio) {
		this.capacidadeInicio = capacidadeInicio;
	}


	public int getCapacidadeMax() {
		return capacidadeMax;
	}


	public void setCapacidadeMax(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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


	public boolean isGratuito() {
		return isGratuito;
	}


	public void setGratuito(boolean isGratuito) {
		this.isGratuito = isGratuito;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
