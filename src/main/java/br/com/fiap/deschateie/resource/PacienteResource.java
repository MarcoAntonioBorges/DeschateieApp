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

import br.com.fiap.deschateie.model.Paciente;
import br.com.fiap.deschateie.model.Usuario;
import br.com.fiap.deschateie.repository.PacienteRepository;
import br.com.fiap.deschateie.repository.UsuarioRepository;

@RestController
@RequestMapping("paciente")
public class PacienteResource {
	
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<Paciente> buscarTodos(Pageable pageable){
        return pacienteRepository.findAll(pageable);
    }

    @GetMapping("pesquisa")
    public Page<Paciente> buscarPorNome(@RequestParam String nome,Pageable pageable){
        return pacienteRepository.findByNomeUsuario(nome,pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable long id){
        Optional<Paciente> optional = pacienteRepository.findById(id);
        if(optional.isPresent()) {
        	return 	ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.CREATED)
    public Paciente cadastrar(@PathVariable long id, @RequestBody Paciente paciente) {
    	paciente.setId(id);
        Paciente novoPaciente = new Paciente(paciente);
        return pacienteRepository.save(novoPaciente);
    }

    @PutMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public Paciente alterar(@RequestBody Paciente paciente, @PathVariable long id){
    	Paciente pacienteNovo = new Paciente(paciente);
        pacienteNovo.setId(id);
        return pacienteRepository.save(pacienteNovo);
    }

    @DeleteMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public void remover(@PathVariable long id){
        pacienteRepository.deleteById(id);
    }

}
