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

import br.com.fiap.deschateie.model.NumeroPermissao;
import br.com.fiap.deschateie.model.Voluntario;
import br.com.fiap.deschateie.repository.VolutarioRepository;

@RestController
@RequestMapping("voluntario")
public class VoluntarioResource {
    @Autowired
    private VolutarioRepository volutarioRepository;

    @GetMapping
    public Page<Voluntario> buscarTodos(Pageable pageable){
        return  volutarioRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable long id){
        Optional<Voluntario> optional = volutarioRepository.findById(id);
        if(optional.isPresent()) {
        	return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("pesquisa")
    public Page<Voluntario> pesquisarPorNome(@RequestParam String nome, Pageable pageable){
        return volutarioRepository.findByNomeUsuario(nome,pageable);
    }

    @PostMapping("cadastrar")
    @Transactional
    @ResponseStatus(value=HttpStatus.CREATED)
    public Voluntario cadastrar(@RequestBody Voluntario voluntario){
        voluntario.setNivelPermissao(NumeroPermissao.P3);
        return volutarioRepository.save(voluntario);
    }

    @PutMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public Voluntario alterar(@RequestBody Voluntario voluntario,@PathVariable long id){
        voluntario.setId(id);
        return volutarioRepository.save(voluntario);
    }

    @DeleteMapping("{id}")
    @Transactional
    @ResponseStatus(value=HttpStatus.OK)
    public void deletar(@PathVariable long id){
        volutarioRepository.deleteById(id);
    }
}
