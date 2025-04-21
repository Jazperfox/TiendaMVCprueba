package org.jason.backend.services;


import org.jason.backend.models.Usuario;
import org.jason.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepo;

    public Optional<Usuario> login(String usuario, String contrasena)
    {
        return usuarioRepo.findByUsuarioAndContrasena(usuario,contrasena);
    }

    public Usuario crear(Usuario u)
    {
        return usuarioRepo.save(u);
    }
}
