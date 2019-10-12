package br.com.fiap.deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.deschateie.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

	Page<Evento> findByNome(String nome, Pageable filtro);

}
