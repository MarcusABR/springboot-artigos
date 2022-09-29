package br.com.bb.letscode.artigos.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.letscode.artigos.entity.Comentario;
import br.com.bb.letscode.artigos.entity.Usuario;
import br.com.bb.letscode.artigos.service.ComentarioService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/comentarios")
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

    @Cacheable("comentarios_user")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Comentario>> getByUserId(@PathVariable("id") Long userId){
        return ResponseEntity.ok(comentarioService.findByUserId(userId));
    }

    @GetMapping(value = {
        "/artigo/{id}/{user}",
        "/artigo/{id}"
    })
    public ResponseEntity<List<Comentario>> getByArticle(@PathVariable("id") Long articleId, @PathVariable(value = "user", required = false) Long userId){
        return ResponseEntity.ok(comentarioService.findByArticle(articleId, userId));
    }

    @Cacheable("comentarios")
    @GetMapping
    public ResponseEntity<Page<Comentario>> getAll(@RequestParam(value = "filter", required = false) String filter, @ParameterObject 
                                                                            @PageableDefault(size = 20, page = 0) Pageable pageable){
        return ResponseEntity.ok(comentarioService.findAll(filter, pageable));
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id){
        comentarioService.delete(id);
    }

}
