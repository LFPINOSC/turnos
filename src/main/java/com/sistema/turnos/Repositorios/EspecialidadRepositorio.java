package com.sistema.turnos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.turnos.Entidades.Especialida;

public interface EspecialidadRepositorio extends JpaRepository<Especialida,Long> {
    
}
