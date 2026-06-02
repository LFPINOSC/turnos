package com.sistema.turnos.Repositorios;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.turnos.Entidades.Consulta;

public interface ConsultaRepositorio extends JpaRepository<Consulta, Long> {
    Optional<Consulta> findByFechaAndHora(Date fecha, Time hora);
    Optional<List<Consulta>> findByFecha(Date fecha);
}
