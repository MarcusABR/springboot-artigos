package br.com.bb.letscode.artigos.controller;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.letscode.artigos.repository.ArtigoRepository;
import br.com.bb.letscode.artigos.service.ArtigoService;
import lombok.extern.slf4j.Slf4j;
import br.com.bb.letscode.artigos.entity.Artigo;;

@Slf4j
@RestController
@RequestMapping("/artigos")
public class ArtigoController {
    
    @Autowired
    final ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @CachePut(value = "artigo_by_id", key = "#artigo.id")
    @PostMapping
    public ResponseEntity<Artigo> insert(@RequestBody Artigo artigo){
        return ResponseEntity.ok(artigoService.save(artigo));
    }

    //Cacheable
    @Cacheable(cacheNames = "artigo_by_id", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<Artigo> getById(@PathVariable("id") Long id){
       
        return ResponseEntity.ok(artigoService.getById(id));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Artigo>> findByUserId(@PathVariable(value = "id") Long Userid){
        return ResponseEntity.ok(artigoService.findByUserId(Userid));
    }

    @PutMapping("/upvote/{id}")
    public void upvoteArticle(@PathVariable(value = "id") Long id){
        artigoService.upvoteArticle(id);
    }

    @PutMapping("/downvote/{id}")
    public void downvoteArticle(@PathVariable(value = "id") Long id){
        artigoService.dowvoteArticle(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        artigoService.delete(id);
    }

}
