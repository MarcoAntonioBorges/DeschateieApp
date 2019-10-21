package br.com.fiap.Deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Deschateie.model.Voluntario;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long>{

	Page<Voluntario> findByNome(String nome, Pageable paginacao);

	Page<Voluntario> findByEmail(String email, Pageable paginacao);

}
