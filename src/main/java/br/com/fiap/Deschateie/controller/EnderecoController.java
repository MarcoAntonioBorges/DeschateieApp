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

import br.com.fiap.DeschateieDemo.controller.dto.EnderecoDTO;
import br.com.fiap.DeschateieDemo.controller.form.EnderecoForm;
import br.com.fiap.DeschateieDemo.model.Endereco;
import br.com.fiap.DeschateieDemo.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repository;

	@GetMapping
	public Page<EnderecoDTO> listar(@RequestParam(required = false) String cidade,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Endereco> enderecos;
		if (cidade != null) {
			enderecos = repository.findByCidade(cidade, paginacao);
		} else {
			enderecos = repository.findAll(paginacao);
		}
		return EnderecoDTO.converter(enderecos);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<EnderecoDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Endereco> endereco = repository.findById(codigo);
		if (endereco.isPresent()) {
			return ResponseEntity.ok(new EnderecoDTO(endereco.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody @Valid EnderecoForm form,
			UriComponentsBuilder uriBuilder) {

		Endereco endereco = form.converter();
		repository.save(endereco);

		URI uri = uriBuilder.path("/enderecos/{codigo}").buildAndExpand(endereco.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid EnderecoForm form) {
		Optional<Endereco> optional = repository.findById(codigo);
		if (optional.isPresent()) {
			Endereco endereco = form.atualizar(codigo, repository);
			return ResponseEntity.ok(new EnderecoDTO(endereco));
		}
		return ResponseEntity.notFound().build();
	}

}
