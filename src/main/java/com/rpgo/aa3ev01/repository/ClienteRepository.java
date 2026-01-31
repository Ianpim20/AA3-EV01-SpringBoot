package com.rpgo.aa3ev01.repository;

import com.rpgo.aa3ev01.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Cliente.
 * Proporciona operaciones CRUD sin escribir SQL.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}