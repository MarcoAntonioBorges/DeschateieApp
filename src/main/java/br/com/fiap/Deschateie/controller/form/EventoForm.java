package br.com.fiap.Deschateie.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.Deschateie.model.Endereco;
import br.com.fiap.Deschateie.model.Evento;
import br.com.fiap.Deschateie.model.Logradouro;
import br.com.fiap.Deschateie.model.Tipo;
import br.com.fiap.Deschateie.repository.EventoRepository;

public class EventoForm {

	@NotNull @Length(max = 100)
	private String nome;
	
	@NotNull
	private Boolean isGratuito;
	
	@NotNull
	private Long capacidade;
	
	@NotNull
	private LocalDate dataInicio;
	
	@NotNull
	private LocalDate dataFim;
	
	@NotNull @Length(max = 500)
	private String descricao;
	
	@NotNull @Length(max = 120)
	private String foto;
	
	@NotNull
	private Tipo tipo;
	
	@NotNull
	private Logradouro logradouro;
	
	@NotNull @Length(max = 20)
	private String numero;
	
	@NotNull @Length(max = 500)
	private String complemento;
	
	@NotNull
	private Long cep;
	
	@NotNull
	private String bairro;
	
	@NotNull @Length(max = 50)
	private String cidade;
	
	@NotNull @Length(max = 10)
	private String uf;
	
	@NotNull @Length(max = 50)
	private String pais;
	

	public Evento converter() {
		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, bairro, cidade, uf, pais);
		return new Evento(nome, isGratuito, capacidade, dataInicio, dataFim, descricao, tipo, foto, endereco);
	}


	public Evento atualizar(Long codigo,
			EventoRepository repository) {
		Evento evento = repository.getOne(codigo);
		
		evento.setCapacidade(this.capacidade);
		evento.setDataInicio(this.dataInicio);
		evento.setDataFim(this.dataFim);
		evento.setDescricao(this.descricao);
		evento.setFoto(this.foto);
		evento.setTipo(this.tipo);
		evento.setIsGratuito(this.isGratuito);
		
		return evento;
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


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
