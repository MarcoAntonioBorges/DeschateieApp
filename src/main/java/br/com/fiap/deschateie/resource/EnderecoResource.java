package br.com.fiap.deschateie.resource;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.deschateie.model.Endereco;
import br.com.fiap.deschateie.repository.EnderecoRepository;

@RestController
@RequestMapping("endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @GetMapping("{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable long id){
    	Optional<Endereco> optional = enderecoRepository.findById(id);
    	if(optional.isPresent()) {
    		return ResponseEntity.ok(optional.get());
    	}
    	return ResponseEntity.badRequest().build();
    }
    
    @GetMapping
    public Page<Endereco> buscarTodosEndereco(Pageable filtro){
    	return enderecoRepository.findAll(filtro);
    }
    
    @PostMapping
    @Transactional
    @ResponseStatus(value=HttpStatus.CREATED)
    public Endereco cadastrar(@RequestBody Endereco endereco) {
    	return enderecoRepository.save(endereco);
    }
    
    @PutMapping("{codigo}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public Endereco atualizar(@PathVariable long codigo, @RequestBody Endereco endereco) {
    	endereco.setId(codigo);
    	return enderecoRepository.save(endereco);
    }
    
    @DeleteMapping("{codigo}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public void deletar(@PathVariable long codigo) {
    	enderecoRepository.delete(enderecoRepository.getOne(codigo));
    }
}
