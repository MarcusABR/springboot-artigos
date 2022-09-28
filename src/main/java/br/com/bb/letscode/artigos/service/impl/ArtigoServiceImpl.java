package br.com.bb.letscode.artigos.service.impl;
import br.com.bb.letscode.artigos.service.ArtigoService;
import br.com.bb.letscode.artigos.entity.Artigo;
import br.com.bb.letscode.artigos.repository.ArtigoRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtigoServiceImpl implements ArtigoService{
    
    final ArtigoRepository artigoRepository;

    public ArtigoServiceImpl(ArtigoRepository artigoRepository){
        this.artigoRepository = artigoRepository;
    }

    @Override
    public Artigo save(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    @Override
    public void delete(Long id) {
        artigoRepository.deleteById(id);
    }

    @Override
    public Artigo getById(Long id) {
        return artigoRepository.findById(id).get();
    }

    @Override
    public List<Artigo> findAll() {
        return artigoRepository.findAll();
    }

    @Override
    public List<Artigo> findByUserId(Long articleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void upvoteArticle(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dowvoteArticle(Long id) {
        // TODO Auto-generated method stub
        
    }











    // Artigo save(Artigo artigo);

    // void delete(Long id);

    // List<Comentario> findAll();

    // List<Comentario> findByUserId(Long articleId);

    // void upvoteArticle(Long id);

    // void dowvoteArticle(Long id);
}
