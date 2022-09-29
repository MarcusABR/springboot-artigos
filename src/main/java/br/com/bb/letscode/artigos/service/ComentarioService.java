package br.com.bb.letscode.artigos.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.bb.letscode.artigos.entity.Comentario;

public interface ComentarioService {
    Comentario save(Comentario comentario);

    void delete(Long id);

    Page<Comentario> findAll(String filter, Pageable pageable) ;

    List<Comentario> findByArticle(Long articleId);

    List<Comentario> findByArticle(Long articleId, Long usuarioId);

    List<Comentario> findByUserId(Long articleId);

}
