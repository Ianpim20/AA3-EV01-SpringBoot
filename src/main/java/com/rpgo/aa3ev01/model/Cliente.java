package com.rpgo.aa3ev01.model;

import jakarta.persistence.*;

/**
 * Entidad JPA: representa un cliente dentro del sistema.
 * Hibernate creará/actualizará la tabla "clientes" a partir de esta clase.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(length = 20)
    private String telefono;

    // Constructor vacío obligatorio para JPA
    public Cliente() {
    }

    // Constructor útil para crear objetos rápidamente
    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // ===== Getters y Setters (estándar de codificación) =====

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}