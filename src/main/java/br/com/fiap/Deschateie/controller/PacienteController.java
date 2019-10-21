package br.com.fiap.Deschateie.controller;

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

import br.com.fiap.Deschateie.controller.dto.PacienteDTO;
import br.com.fiap.Deschateie.controller.form.AtualizacaoPacienteForm;
import br.com.fiap.Deschateie.controller.form.PacienteForm;
import br.com.fiap.Deschateie.model.Paciente;
import br.com.fiap.Deschateie.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@GetMapping
	public Page<PacienteDTO> listar(@RequestParam(required = false) String nome,
			@RequestParam(required = false) String email,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Paciente> pacientes;
		if (nome != null) {
			pacientes = repository.findByNome(nome, paginacao);
		} else if (email != null) {
			pacientes = repository.findByEmail(email, paginacao);
		} else {
			pacientes = repository.findAll(paginacao);
		}
		return PacienteDTO.converter(pacientes);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<PacienteDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Paciente> paciente = repository.findById(codigo);
		if (paciente.isPresent()) {
			return ResponseEntity.ok(new PacienteDTO(paciente.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PacienteDTO> cadastrar(@RequestBody @Valid PacienteForm form,
			UriComponentsBuilder uriBuilder) {

		Paciente paciente = form.converter();
		repository.save(paciente);

		URI uri = uriBuilder.path("/pacientes/{codigo}").buildAndExpand(paciente.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new PacienteDTO(paciente));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<PacienteDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid AtualizacaoPacienteForm form) {
		Optional<Paciente> optional = repository.findById(codigo);
		if (optional.isPresent()) {
			Paciente paciente = form.atualizar(codigo, repository);
			return ResponseEntity.ok(new PacienteDTO(paciente));
		}
		return ResponseEntity.notFound().build();
	}

}
