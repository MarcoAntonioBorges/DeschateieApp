package br.com.fiap.deschateie.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.fiap.deschateie.model.Endereco;
import br.com.fiap.deschateie.model.Evento;
import br.com.fiap.deschateie.model.Tipo;

public class EventoDTO {

	private String nome;
	private Boolean isGratuito;
	private Long capacidade;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String descricao;
	private Tipo tipo;
	private String foto;
	private Endereco endereco;

	public EventoDTO(Evento evento) {
		super();
		this.nome = evento.getNome();
		this.isGratuito = evento.getIsGratuito();
		this.capacidade = evento.getCapacidade();
		this.dataInicio = evento.getDataInicio();
		this.dataFim = evento.getDataFim();
		this.descricao = evento.getDescricao();
		this.foto = evento.getFoto();
		this.tipo = evento.getTipo();
		this.endereco = evento.getEndereco();

	}

	public EventoDTO() {
		super();
	}

	public EventoDTO(String nome, Boolean isGratuito, Long capacidade, LocalDate dataInicio, LocalDate dataFim,
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public static Page<EventoDTO> converter(Page<Evento> eventos) {
		return eventos.map(EventoDTO::new);
	}
}
