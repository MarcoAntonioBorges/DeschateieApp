package br.com.fiap.Deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Deschateie.model.Psicologo;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long>{

	Page<Psicologo> findByNome(String nome, Pageable paginacao);

	Page<Psicologo> findByEmail(String email, Pageable paginacao);

}
