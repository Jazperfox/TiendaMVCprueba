package org.jason.backend.controllers;


import org.jason.backend.models.Usuario;
import org.jason.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepo;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user){
        Optional<Usuario> u=usuarioRepo.findByUsuarioAndContrasena(user.getUsuario(),user.getContrasena());
        return u.isPresent() ? ResponseEntity.ok(u.get()) : ResponseEntity.status(401).body("Credenciales incorrectas");
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario user)
    {
        return ResponseEntity.ok(usuarioRepo.save(user));
    }
}
