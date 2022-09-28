package br.com.bb.letscode.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.letscode.artigos.entity.Usuario;
import br.com.bb.letscode.artigos.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
        log.info(usuario.toString());
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = {
        "/",
        "/{id}"
    })
    public ResponseEntity<List<Usuario>> getAll(@PathVariable(value = "id", required = false) Long id){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
}