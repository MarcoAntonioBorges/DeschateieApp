package br.com.fiap.Deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.Deschateie.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Page<Usuario> findByNome(String nome, Pageable paginacao);

	Page<Usuario> findByEmail(String email, Pageable paginacao);

	Usuario findByEmail(String email);

}
