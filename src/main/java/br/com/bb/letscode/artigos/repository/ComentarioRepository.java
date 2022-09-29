package br.com.bb.letscode.artigos.repository;
import br.com.bb.letscode.artigos.entity.Comentario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    public Page<Comentario> findByNomeContainingAndTextoContaining(String nome, String texto, Pageable pageable);
}
