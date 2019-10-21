package br.com.fiap.DeschateieDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DeschateieDemo.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Page<Paciente> findByNome(String nome, Pageable paginacao);

	Page<Paciente> findByEmail(String email, Pageable paginacao);

}
