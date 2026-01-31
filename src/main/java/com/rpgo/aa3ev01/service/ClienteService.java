package com.rpgo.aa3ev01.service;

import com.rpgo.aa3ev01.model.Cliente;
import com.rpgo.aa3ev01.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Capa de servicio: contiene la lógica de negocio
 * relacionada con los clientes.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Inyección de dependencias por constructor (buena práctica)
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}