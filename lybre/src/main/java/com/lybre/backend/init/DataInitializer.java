package com.lybre.backend.init;

import com.lybre.backend.model.Usuario;
import com.lybre.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        if (usuarioRepository.count() == 0) {
            usuarioRepository.save(new Usuario("Juan", "Pérez", "juan.perez@example.com","primero"));
            usuarioRepository.save(new Usuario("María", "González", "maria.gonzalez@example.com","segundo"));
            usuarioRepository.save(new Usuario("Carlos", "Sánchez", "carlos.sanchez@example.com","tercero"));
            usuarioRepository.save(new Usuario("Ana", "Martínez", "ana.martinez@example.com","cuarto"));
            usuarioRepository.save(new Usuario("Luis", "Rodríguez", "luis.rodriguez@example.com","quinto"));
        }
    }
}
