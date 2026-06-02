package com.sistema.turnos.Entidades;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe seleccionar un médico")
    @ManyToOne(optional = false)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @NotNull(message = "Debe seleccionar un consultorio")
    @ManyToOne(optional = false)
    @JoinColumn(name = "consultorio_id", nullable = false)
    private Consultorio consultorio;

    @NotNull(message = "Debe seleccionar un paciente")
    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @NotBlank(message = "El motivo de la consulta es obligatorio")
    @Size(min = 5, max = 500,
          message = "El motivo debe tener entre 5 y 500 caracteres")
    @Column(nullable = false, length = 500)
    private String motivo;

    @NotNull(message = "La fecha es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @NotNull(message = "La hora es obligatoria")
    @Column(nullable = false)
    private Time hora;

    @Min(value = 0, message = "Estado inválido")
    @Max(value = 2, message = "Estado inválido")
    @Column(nullable = false)
    private int estado;

    @DecimalMin(value = "0.00", message = "El costo no puede ser negativo")
    @Digits(integer = 8, fraction = 2,
            message = "Formato de costo inválido")
    @Column(nullable = false)
    private double costo;
    

}
