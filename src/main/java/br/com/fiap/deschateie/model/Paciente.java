package br.com.fiap.deschateie.model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_SCP_PACIENTE")
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Usuario {



    /**
	 * 
	 */
	private static final long serialVersionUID = -2500414515296993206L;
	
	@Column(name = "nr_cpf",nullable = false,unique = true,length = 11)
    private long cpf;

    @Column(name = "ds_cep",length = 8,nullable = false)
    private String cep ;

    @Column(name = "ds_historico",length = 2000)
    private String historico;

    @Column(name = "nr_consultas_realizadas",nullable = false,length = 3)
    private int consultasRealizadas;

    
    
    
	public Paciente(String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha, String foto,
			String genero, long cpf, String cep, String historico, int consultasRealizadas) {
		super(nomeUsuario, email, dataNascimento, login, senha, foto, genero);
		this.cpf = cpf;
		this.cep = cep;
		this.historico = historico;
		this.consultasRealizadas = consultasRealizadas;
	}
	
	
	
	public Paciente(long id, String nomeUsuario, String email, LocalDate dataNascimento, String login, String senha, String foto, String genero, long cpf, String cep, String historico,
			int consultasRealizadas) {
		super(id, nomeUsuario, email, dataNascimento, login, senha, NumeroPermissao.P1, foto, genero);
		this.cpf = cpf;
		this.cep = cep;
		this.historico = historico;
		this.consultasRealizadas = consultasRealizadas;
	}



	public Paciente() {
		super();
	}

	public Paciente(Paciente paciente) {
		super(paciente.getId(), paciente.getNomeUsuario(), paciente.getEmail(), paciente.getDataNascimento(), paciente.getLogin(), paciente.getSenha(), NumeroPermissao.P1, paciente.getFoto(), paciente.getGenero());
		this.cpf = paciente.getCpf();
		this.cep = paciente.getCep();
		this.historico = paciente.getHistorico();
		this.consultasRealizadas = paciente.getConsultasRealizadas();
	}



	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getConsultasRealizadas() {
		return consultasRealizadas;
	}

	public void setConsultasRealizadas(int consultasRealizadas) {
		this.consultasRealizadas = consultasRealizadas;
	}

}
