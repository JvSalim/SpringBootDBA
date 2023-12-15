package com.example.demo.services;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Injeção de dependência do repositório
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Long getTotalUsuariosCount() {
        return usuarioRepository.getTotalUsuariosCount();
    }
}
