package br.com.bb.letscode.artigos.service;

import java.util.List;

import br.com.bb.letscode.artigos.entity.Artigo;

public interface ArtigoService {

    Artigo save(Artigo artigo);

    void delete(Long id);

    public Artigo getById(Long id);

    List<Artigo> findAll();

    List<Artigo> findByUserId(Long articleId);

    void upvoteArticle(Long id);

    void dowvoteArticle(Long id);
}
