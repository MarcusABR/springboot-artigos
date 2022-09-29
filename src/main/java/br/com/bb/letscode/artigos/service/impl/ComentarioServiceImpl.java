package br.com.bb.letscode.artigos.service.impl;
import br.com.bb.letscode.artigos.service.ComentarioService;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Comentario> findAll(String filter, Pageable pageable) {
        return comentarioRepository.findByNomeContainingAndTextoContaining(filter, filter, pageable);
    }

    @Override
    public List<Comentario> findByArticle(Long articleId) {
        Artigo artigo = new Artigo();
        artigo.setId(articleId);
        Comentario comentario = new Comentario();
        comentario.setArtigo(artigo);

        final ExampleMatcher exampleMatcher = 
                ExampleMatcher  
                        .matchingAny();

        Example<Comentario> comentarioExample = Example.of(comentario, exampleMatcher);

        

        return comentarioRepository.findAll(comentarioExample);
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
