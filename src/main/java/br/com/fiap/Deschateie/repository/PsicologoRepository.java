package br.com.fiap.DeschateieDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DeschateieDemo.model.Psicologo;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long>{

	Page<Psicologo> findByNome(String nome, Pageable paginacao);

	Page<Psicologo> findByEmail(String email, Pageable paginacao);

}
