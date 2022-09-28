package br.com.bb.letscode.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bb.letscode.artigos.entity.Comentario;
import br.com.bb.letscode.artigos.entity.Usuario;
import br.com.bb.letscode.artigos.service.ComentarioService;

public class ComentarioController {
    
    @Autowired
    final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<Comentario> insert(@RequestBody Comentario comentario){
        return ResponseEntity.ok(comentarioService.save(comentario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getByUserId(@PathVariable("id") Long userd){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getByArticle(@PathVariable("id") Long articleId, @PathVariable(value = "user", required = false) Long id){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Comentario>> getAll(@PathVariable(value = "id", required = false) Long id){
        return ResponseEntity.ok(comentarioService.findAll());
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id){
        comentarioService.delete(id);
    }

    // @GetMapping(value = {
    //     "/",
    //     "/{id}"
    // })
    // public ResponseEntity<List<Usuario>> getAll(@PathVariable(value = "id", required = false) Long id){
    //     return ResponseEntity.ok(usuarioRepository.findAll());
    // }


    // List<Comentario> findByArticle(Long articleId);

    // List<Comentario> findByArticle(Long articleId, Long usuarioId);

    // List<Comentario> findByUserId(Long articleId);
}
