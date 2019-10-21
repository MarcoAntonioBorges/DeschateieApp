package br.com.fiap.Deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Deschateie.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Page<Paciente> findByNome(String nome, Pageable paginacao);

	Page<Paciente> findByEmail(String email, Pageable paginacao);

}
