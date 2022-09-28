package br.com.bb.letscode.artigos.service;
import java.util.List;

import br.com.bb.letscode.artigos.entity.Comentario;

public interface ComentarioService {
    Comentario save(Comentario comentario);

    void delete(Long id);

    List<Comentario> findAll();

    List<Comentario> findByArticle(Long articleId);

    List<Comentario> findByArticle(Long articleId, Long usuarioId);

    List<Comentario> findByUserId(Long articleId);

}
