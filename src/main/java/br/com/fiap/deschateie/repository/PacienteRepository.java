package br.com.fiap.deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.deschateie.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Page<Paciente> findByNomeUsuario(String nome, Pageable pageable);
}
