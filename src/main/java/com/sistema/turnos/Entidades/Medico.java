package com.sistema.turnos.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter; 

@Entity
@Table
@Getter
@Setter
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    @ManyToOne
    private Especialida especialidad;
    private int estado;
}
