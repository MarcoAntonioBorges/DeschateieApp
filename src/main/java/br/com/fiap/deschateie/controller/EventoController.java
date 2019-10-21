package br.com.fiap.deschateie.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.deschateie.controller.dto.EventoDTO;
import br.com.fiap.deschateie.controller.form.EventoForm;
import br.com.fiap.deschateie.model.Evento;
import br.com.fiap.deschateie.repository.EventoRepository;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoRepository repository;

	@GetMapping
	public Page<EventoDTO> listar(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Evento> eventos;
		if (nome != null) {
			eventos = repository.findByNome(nome, paginacao);
		} else {
			eventos = repository.findAll(paginacao);
		}
		return EventoDTO.converter(eventos);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<EventoDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Evento> evento = repository.findById(codigo);
		if (evento.isPresent()) {
			return ResponseEntity.ok(new EventoDTO(evento.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EventoDTO> cadastrar(@RequestBody @Valid EventoForm form,
			UriComponentsBuilder uriBuilder) {

		Evento evento = form.converter();
		repository.save(evento);

		URI uri = uriBuilder.path("/eventos/{codigo}").buildAndExpand(evento.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new EventoDTO(evento));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<EventoDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid EventoForm form) {
		Optional<Evento> optional = repository.findById(codigo);
		if (optional.isPresent()) {
			Evento evento = form.atualizar(codigo, repository);
			return ResponseEntity.ok(new EventoDTO(evento));
		}
		return ResponseEntity.notFound().build();
	}

}
