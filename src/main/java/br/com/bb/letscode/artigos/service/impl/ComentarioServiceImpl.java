package br.com.bb.letscode.artigos.service.impl;
import br.com.bb.letscode.artigos.service.ComentarioService;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bb.letscode.artigos.entity.Artigo;
import br.com.bb.letscode.artigos.entity.Comentario;
import br.com.bb.letscode.artigos.repository.ComentarioRepository;


@Service
public class ComentarioServiceImpl implements ComentarioService{
    final ComentarioRepository comentarioRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository){
        this.comentarioRepository = comentarioRepository;
    }

   

    @Override
    public void delete(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comentario> findByArticle(Long articleId) {
        return null;
    }

    @Override
    public List<Comentario> findByArticle(Long articleId, Long usuarioId) {
        return null;
    }

    @Override
    public List<Comentario> findByUserId(Long articleId) {
        return null;
    }



    @Override
    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
}
