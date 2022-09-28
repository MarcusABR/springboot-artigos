package br.com.bb.letscode.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bb.letscode.artigos.repository.ArtigoRepository;
import br.com.bb.letscode.artigos.entity.Artigo;;

public class ArtigoController {
    //GetById
    //GetAllByUser
    //CreateArticle
    //DeleteArticle
    //GetAll
    //UpvoteArticle
    //DownvoteArticle
    @Autowired
    final ArtigoRepository artigoRepository;

    public ArtigoController(ArtigoRepository artigoRepository) {
        this.artigoRepository = artigoRepository;
    }

    @PostMapping
    public ResponseEntity<Artigo> insert(@RequestBody Artigo artigo){
        return ResponseEntity.ok(artigoRepository.save(artigo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> getById(@PathVariable("id") Long id){
        Artigo usuario = new Artigo();
        usuario.setId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = {
        "/",
        "/{id}"
    })
    public ResponseEntity<List<Artigo>> getAll(@PathVariable(value = "id", required = false) Long id){
        return ResponseEntity.ok(artigoRepository.findAll());
    }
}
