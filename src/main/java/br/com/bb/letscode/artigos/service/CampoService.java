package br.com.bb.letscode.artigos.service;

import java.util.List;

import br.com.bb.letscode.artigos.entity.Campo;

public interface CampoService {
    Campo save(Campo campo);

    List<Campo> findAll();

    Campo getById(String nome);

    void delete(String nome);
}
