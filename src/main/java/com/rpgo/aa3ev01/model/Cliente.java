package com.rpgo.aa3ev01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 80, message = "El nombre debe tener entre 3 y 80 caracteres")
    @Column(nullable = false, length = 80)
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato valido")
    @Size(max = 120, message = "El email no puede superar 120 caracteres")
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Pattern(
            regexp = "^[0-9]{7,15}$",
            message = "El telefono debe tener solo numeros y entre 7 y 15 digitos"
    )
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