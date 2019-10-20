package br.com.fiap.DeschateieDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DeschateieDemo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	Page<Endereco> findByCidade(String cidade, Pageable paginacao);

}
