package br.com.bb.letscode.artigos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.letscode.artigos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
