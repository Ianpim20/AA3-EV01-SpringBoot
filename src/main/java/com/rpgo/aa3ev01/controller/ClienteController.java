package com.rpgo.aa3ev01.controller;

import com.rpgo.aa3ev01.model.Cliente;
import com.rpgo.aa3ev01.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // POST http://localhost:8080/clientes
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }
}