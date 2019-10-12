package br.com.fiap.deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.deschateie.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
    public Page<Usuario> findByNomeUsuario(String nome, Pageable pageable);
}
