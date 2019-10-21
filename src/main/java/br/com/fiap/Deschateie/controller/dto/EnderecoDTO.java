package br.com.fiap.DeschateieDemo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.fiap.DeschateieDemo.model.Endereco;
import br.com.fiap.DeschateieDemo.model.Logradouro;

public class EnderecoDTO{

	private Logradouro logradouro;
	private String numero;
	private String complemento;
	private Long cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	
	public EnderecoDTO(Endereco endereco) {
		super();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cep = endereco.getCep();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
		this.pais = endereco.getPais();
	}
	
	public EnderecoDTO(Logradouro logradouro, String numero, String complemento, Long cep, String bairro, String cidade,
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


	public EnderecoDTO() {
		super();
	}

	
	public Logradouro getLogradouro() {
		return logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public Long getCep() {
		return cep;
	}


	public String getBairro() {
		return bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public String getUf() {
		return uf;
	}


	public String getPais() {
		return pais;
	}


	public static Page<EnderecoDTO> converter(Page<Endereco> enderecos) {
		return enderecos.map(EnderecoDTO::new);
	}
}
