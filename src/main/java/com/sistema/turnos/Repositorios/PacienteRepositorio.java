package com.sistema.turnos.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.turnos.Entidades.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente,Long>{
    Optional<Paciente> findByCedula(String cedula);
}
