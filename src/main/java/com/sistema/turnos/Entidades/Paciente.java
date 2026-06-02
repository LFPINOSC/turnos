package com.sistema.turnos.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 10, min = 10, message = "La cedula tiene que tener 10 caracteres")
    @NotNull(message = "La cedula no puede ser nula")
    @Column(length = 10, nullable = false, unique = true)
    @Pattern(regexp = "\\d{10}", message = "La cedula debe contener solo números y tener 10 dígitos")
    private String cedula;
    @Size(max = 30, min = 3,message = "El nombre tiene que tener de 3 a 30 caracteres")
    @NotNull(message = "El nombre no puede ser nulo")
    @Column(length = 30, nullable = false)
    private String nombre;
    private String apellido;
    @Size(max = 4, min = 1, message = "El edad tiene que tener entre 1 y 4 caracteres")
    @Pattern(regexp = "\\d{1,4}", message = "La edad debe contener solo números y tener entre 1 y 4 dígitos")
    private int edad;
    private String direccion;
    private String telefono;
    @ManyToOne
    private Genero genero;
    @Size(max = 50, min = 5, message = "El correo electrónico debe tener entre 5 y 50 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "El correo electrónico no es válido")
    @Column(length = 50, nullable = false, unique = true)
    private String correo;
    private int estado;

}
