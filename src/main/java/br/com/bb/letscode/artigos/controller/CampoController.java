package br.com.bb.letscode.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bb.letscode.artigos.entity.Campo;
import br.com.bb.letscode.artigos.service.CampoService;

public class CampoController {
    
    @Autowired
    final CampoService campoService;

    public CampoController(CampoService campoService) {
        this.campoService = campoService;
    }

    @PostMapping
    public ResponseEntity<Campo> insert(@RequestBody Campo campo){
        return ResponseEntity.ok(campoService.save(campo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campo> getById(@PathVariable("id") String nome){
        return ResponseEntity.ok(campoService.getById(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Campo>> getAll(@PathVariable(value = "id", required = false) Long id){
        return ResponseEntity.ok(campoService.findAll());
    }
}
