package com.lybre.backend.controller;

import com.lybre.backend.model.Usuario; // Asegúrate de tener este import
import com.lybre.backend.service.UsuarioService; // Asegúrate de tener este import
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "usuarios", description = "Operaciones relacionadas con usuarios")
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
    @Operation(summary = "Agregar un usuario",
            description = "Se agrega un usuario que podrá acceder a la base de datos")
    @PostMapping("/usuarios") // Agrega un path específico si es necesario
    public ResponseEntity<Usuario> guardarUsuario(
            @Parameter(description = "El usuario a ser guardado") @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
