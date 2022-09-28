package br.com.bb.letscode.artigos.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import br.com.bb.letscode.artigos.entity.Usuario;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Usuario getById(Long userId);
}
