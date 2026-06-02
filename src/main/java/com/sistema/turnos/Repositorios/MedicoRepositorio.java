package com.sistema.turnos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.turnos.Entidades.Medico;

public interface MedicoRepositorio extends JpaRepository<Medico,Long>{
    
}
