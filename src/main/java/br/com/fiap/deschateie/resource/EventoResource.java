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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.deschateie.model.Evento;
import br.com.fiap.deschateie.repository.EventoRepository;

@RestController
@RequestMapping("evento")
public class EventoResource {

	@Autowired
	private EventoRepository repository;
	
	@GetMapping
	@ResponseStatus(value=HttpStatus.OK)
	public Page<Evento> buscarTodosEventos(Pageable filtro){
		return repository.findAll(filtro);
	}
	
	@GetMapping("pesquisa")
	@ResponseStatus(value=HttpStatus.OK)
	public Page<Evento> buscarPorNome(@RequestParam String nome, Pageable filtro) {
		return repository.findByNome(nome, filtro);
	}
	
	@GetMapping("{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable long id){
        Optional<Evento> optional = repository.findById(id);
        if(optional.isPresent()) {
        	return 	ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("cadastrar")
    @Transactional
    @ResponseStatus(value=HttpStatus.CREATED)
    public Evento cadastrar(@RequestBody Evento evento) {
        return repository.save(evento);
    }

    @PutMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public Evento alterar(@RequestBody Evento evento, @PathVariable long id){
        evento.setCodigo(id);
        return repository.save(evento);
    }

    @DeleteMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public void remover(@PathVariable long id){
        repository.deleteById(id);
    }

	
}
