package br.com.fiap.DeschateieDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DeschateieDemo.model.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long>{

	Page<Voluntario> findByNome(String nome, Pageable paginacao);

	Page<Voluntario> findByEmail(String email, Pageable paginacao);

}
