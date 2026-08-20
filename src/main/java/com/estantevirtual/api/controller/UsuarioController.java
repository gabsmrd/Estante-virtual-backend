package com.estantevirtual.api.controller;

import com.estantevirtual.api.entity.UsuarioEntity;
import com.estantevirtual.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Endpoint de Cadastro
    @PostMapping("/cadastrar")
    public UsuarioEntity cadastrar(@RequestBody UsuarioEntity usuario) {
        // Define valores padrão caso não sejam informados
        if (usuario.getMetaLeitura() == null) usuario.setMetaLeitura(20);
        if (usuario.getFotoUrl() == null) usuario.setFotoUrl("https://i.pravatar.cc/150?img=5");

        return usuarioRepository.save(usuario);
    }

    // Endpoint de Login
    @PostMapping("/login")
    public UsuarioEntity login(@RequestBody UsuarioEntity loginData) {
        Optional<UsuarioEntity> user = usuarioRepository.findByEmail(loginData.getEmail());

        if (user.isPresent() && user.get().getSenha().equals(loginData.getSenha())) {
            return user.get(); // Login bem-sucedido
        }

        throw new RuntimeException("E-mail ou senha inválidos!");
    }
}