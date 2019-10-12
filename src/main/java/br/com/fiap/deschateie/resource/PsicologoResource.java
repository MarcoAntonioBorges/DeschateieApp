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
import br.com.fiap.deschateie.model.Psicologo;
import br.com.fiap.deschateie.repository.PsicologoRepository;

@RestController
@RequestMapping("psicologo")
public class PsicologoResource {

    @Autowired
    private  PsicologoRepository psicologoRepository;

    @GetMapping
    public Page<Psicologo> buscarTodos(Pageable pageable){
        return psicologoRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Psicologo> buscarPorId(@PathVariable long id){        Optional<Psicologo> psicologo = psicologoRepository.findById(id);
        if(psicologo.isPresent()) {
        	return ResponseEntity.ok(psicologo.get());        	
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("pesquisa")
    public Page<Psicologo> pesquisarPorNome(@RequestParam String nome,Pageable pageable){
        return psicologoRepository.findByNomeUsuario(nome,pageable);
    }

    @PostMapping("cadastrar")
    @Transactional
    @ResponseStatus(value=HttpStatus.CREATED)
    public Psicologo cadastrar(@RequestBody Psicologo psicologo){
        psicologo.setNivelPermissao(NumeroPermissao.P1);
        return psicologoRepository.save(psicologo);
    }

    @PutMapping("{id}")
    @Transactional
    public Psicologo alterar(@RequestBody Psicologo psicologo,@PathVariable long id){
        psicologo.setId(id);
        return psicologoRepository.save(psicologo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value=HttpStatus.OK)
    @Transactional
    public void deletar(@PathVariable long id){
        psicologoRepository.deleteById(id);
    }
}
