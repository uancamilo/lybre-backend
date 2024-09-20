package com.lybre.backend.controller;

import com.lybre.backend.model.Usuario; // Asegúrate de tener este import
import com.lybre.backend.service.UsuarioService; // Asegúrate de tener este import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorNombre(@PathVariable String nombre) {
        List<Usuario> usuarios = usuarioService.buscarPorNombre(nombre);
        return usuarios.isEmpty() ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(usuarios);
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorApellido(@PathVariable String apellido) {
        List<Usuario> usuarios = usuarioService.buscarPorApellido(apellido);
        return usuarios.isEmpty() ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(usuarios);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido) {
        List<Usuario> usuarios = usuarioService.buscarPorNombreYApellido(nombre, apellido);
        return usuarios.isEmpty() ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(usuarios);
    }
    // Método para guardar un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
