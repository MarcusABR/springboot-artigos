package br.com.bb.letscode.artigos.repository;
import br.com.bb.letscode.artigos.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    
}


