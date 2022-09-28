package br.com.bb.letscode.artigos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.letscode.artigos.entity.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long>{
    
}
