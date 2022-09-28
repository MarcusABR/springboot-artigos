package br.com.bb.letscode.artigos.service.impl;
import br.com.bb.letscode.artigos.service.UsuarioService;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bb.letscode.artigos.entity.Usuario;
import br.com.bb.letscode.artigos.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Long userId) {
        return null;
    }
}
