package com.finflow.service;

import com.finflow.entity.Usuario;
import com.finflow.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(Usuario usuario) {
        usuario.setSenha(encriptarSenha(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    public List<Usuario>listaUsuario(){
        return usuarioRepository.findAll();
    }

    private String encriptarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }
}