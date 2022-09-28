package br.com.bb.letscode.artigos.service.impl;
import br.com.bb.letscode.artigos.service.CampoService;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bb.letscode.artigos.entity.Campo;
import br.com.bb.letscode.artigos.repository.CampoRepository;

@Service
public class CampoServiceImpl implements CampoService{
    final CampoRepository campoRepository;

    public CampoServiceImpl(CampoRepository campoRepository){
        this.campoRepository = campoRepository;
    }

    @Override
    public Campo save(Campo campo) {
       
        return  campoRepository.save(campo);
    }

    @Override
    public List<Campo> findAll() {
        return campoRepository.findAll();
    }

    @Override
    public Campo getById(String nome) {
        // TODO Auto-generated method stub
        return  campoRepository.findById(nome).get();
    }

    @Override
    public void delete(String nome) {
        campoRepository.deleteById(nome);        
    }


}
