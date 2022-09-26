package br.com.bb.letscode.artigos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bb.letscode.artigos.dto.UsuarioDTO;

@RestController
public class TesteController {

    @GetMapping("/ola-mundo")
    public ResponseEntity<UsuarioDTO> teste(){
        UsuarioDTO user = new UsuarioDTO();
        user.setNome("Rodrigo");
        user.setEndereco("Rua A 10");
        user.setNome("123");


        return ResponseEntity.ok(user);
    }
}
