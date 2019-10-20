package br.com.fiap.DeschateieDemo.controller;

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

import br.com.fiap.DeschateieDemo.controller.dto.VoluntarioDTO;
import br.com.fiap.DeschateieDemo.controller.form.AtualizacaoVoluntarioForm;
import br.com.fiap.DeschateieDemo.controller.form.VoluntarioForm;
import br.com.fiap.DeschateieDemo.model.Voluntario;
import br.com.fiap.DeschateieDemo.repository.VoluntarioRepository;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

	@Autowired
	private VoluntarioRepository repository;

	@GetMapping
	public Page<VoluntarioDTO> listar(@RequestParam(required = false) String nome,
			@RequestParam(required = false) String email,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Voluntario> voluntarios;
		if (nome != null) {
			voluntarios = repository.findByNome(nome, paginacao);
		} else if (email != null) {
			voluntarios = repository.findByEmail(email, paginacao);
		} else {
			voluntarios = repository.findAll(paginacao);
		}
		return VoluntarioDTO.converter(voluntarios);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<VoluntarioDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Voluntario> voluntario = repository.findById(codigo);
		if (voluntario.isPresent()) {
			return ResponseEntity.ok(new VoluntarioDTO(voluntario.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<VoluntarioDTO> cadastrar(@RequestBody @Valid VoluntarioForm form,
			UriComponentsBuilder uriBuilder) {

		Voluntario voluntario = form.converter();
		repository.save(voluntario);

		URI uri = uriBuilder.path("/voluntarios/{codigo}").buildAndExpand(voluntario.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new VoluntarioDTO(voluntario));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<VoluntarioDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid AtualizacaoVoluntarioForm form) {
		Optional<Voluntario> optional = repository.findById(codigo);
		if (optional.isPresent()) {
			Voluntario voluntario = form.atualizar(codigo, repository);
			return ResponseEntity.ok(new VoluntarioDTO(voluntario));
		}
		return ResponseEntity.notFound().build();
	}

}
