package br.com.fiap.deschateie.controller.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Endereco;
import br.com.fiap.deschateie.model.Logradouro;
import br.com.fiap.deschateie.repository.EnderecoRepository;

public class EnderecoForm {

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
	

	public Endereco converter() {
		return new Endereco(logradouro, numero, complemento, cep, bairro, cidade, uf, pais);
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



	public Endereco atualizar(Long codigo,
			EnderecoRepository repository) {
		Endereco endereco = repository.getOne(codigo);
		
		
		endereco.setLogradouro(this.logradouro);
		endereco.setNumero(this.numero);
		endereco.setComplemento(this.complemento);
		endereco.setCep(this.cep);
		endereco.setBairro(this.bairro);
		endereco.setCidade(this.cidade);
		endereco.setUf(this.uf);
		endereco.setPais(this.pais);
		
		return endereco;
	}
	
}
