package br.com.fiap.deschateie.resource;
import br.com.fiap.deschateie.model.Usuario;
import br.com.fiap.deschateie.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<Usuario> buscarTodos(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    @GetMapping("pesquisa")
    public Page<Usuario> buscarPorNome(@RequestParam String nome,Pageable pageable){
        return usuarioRepository.findByNomeUsuario(nome,pageable);

    }

    @GetMapping("{id}")
    public Optional<Usuario> buscarPorId(@PathVariable long id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario) {
    	Usuario novoUsuario = new Usuario(usuario);
        return new ResponseEntity<>(usuarioRepository.save(novoUsuario),HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public Usuario alterar(@RequestBody @Valid Usuario usuario, @PathVariable long id){
    	Usuario novoUsuario = new Usuario(usuario);
    	novoUsuario.setId(id);
        return usuarioRepository.save(novoUsuario);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable long id){
        usuarioRepository.deleteById(id);
    }
}
