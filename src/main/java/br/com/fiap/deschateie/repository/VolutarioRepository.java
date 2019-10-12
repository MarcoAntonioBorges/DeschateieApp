package br.com.fiap.deschateie.repository;

import br.com.fiap.deschateie.model.Voluntario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolutarioRepository extends JpaRepository<Voluntario,Long> {
    Page<Voluntario> findByNomeUsuario(String nome, Pageable pageable);
}
