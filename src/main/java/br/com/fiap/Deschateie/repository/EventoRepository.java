package br.com.fiap.Deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Deschateie.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

	Page<Evento> findByNome(String nome, Pageable paginacao);


}
