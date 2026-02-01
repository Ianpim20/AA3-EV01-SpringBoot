package com.rpgo.aa3ev01.controller;

import com.rpgo.aa3ev01.model.Cliente;
import com.rpgo.aa3ev01.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de clientes.
 * Expone los servicios del módulo vía HTTP.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // GET http://localhost:8080/clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }

    // GET http://localhost:8080/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<Cliente> encontrado = clienteService.buscarPorId(id);
        return encontrado.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Cliente no encontrado"));
    }

    // POST http://localhost:8080/clientes
    @PostMapping
    public Cliente crearCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    // PUT http://localhost:8080/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Optional<Cliente> encontrado = clienteService.buscarPorId(id);
        if (encontrado.isEmpty()) {
            return ResponseEntity.status(404).body("Cliente no encontrado");
        }

        Cliente actual = encontrado.get();
        actual.setNombre(cliente.getNombre());
        actual.setEmail(cliente.getEmail());
        actual.setTelefono(cliente.getTelefono());

        return ResponseEntity.ok(clienteService.guardar(actual));
    }

    // DELETE http://localhost:8080/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Cliente> encontrado = clienteService.buscarPorId(id);
        if (encontrado.isEmpty()) {
            return ResponseEntity.status(404).body("Cliente no encontrado");
        }
        clienteService.eliminar(id);
        return ResponseEntity.ok("Cliente eliminado");
    }
}