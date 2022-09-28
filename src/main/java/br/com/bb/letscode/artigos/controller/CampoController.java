package br.com.bb.letscode.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bb.letscode.artigos.entity.Campo;
import br.com.bb.letscode.artigos.entity.Usuario;
import br.com.bb.letscode.artigos.repository.CampoRepository;

public class CampoController {
    //CRUD
    //GetAll
    @Autowired
    final CampoRepository campoRepository;

    public CampoController(CampoRepository campoRepository) {
        this.campoRepository = campoRepository;
    }

    @PostMapping
    public ResponseEntity<Campo> insert(@RequestBody Campo campo){
        log.info(campo.toString());
        return ResponseEntity.ok(campoRepository.save(campo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campo> getById(@PathVariable("id") Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return ResponseEntity.ok(Campo);
    }

    @GetMapping(value = {
        "/",
        "/{id}"
    })
    public ResponseEntity<List<Campo>> getAll(@PathVariable(value = "id", required = false) Long id){
        return ResponseEntity.ok(campoRepository.findAll());
    }
}
