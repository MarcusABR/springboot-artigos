package br.com.bb.letscode.artigos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.letscode.artigos.entity.Campo;

public interface CampoRepository extends JpaRepository<Campo, String>{
    
}
