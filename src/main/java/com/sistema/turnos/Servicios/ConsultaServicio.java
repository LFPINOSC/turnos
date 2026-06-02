package com.sistema.turnos.Servicios;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.turnos.Entidades.Consulta;
import com.sistema.turnos.Repositorios.ConsultaRepositorio;

@Service
public class ConsultaServicio {

    @Autowired
    private ConsultaRepositorio consultaRepositorio;

    public List<Consulta> listarConsultas() {
        return consultaRepositorio.findAll();
    }

    public Consulta guardarConsulta(Consulta consulta) {

        // Validar que no exista una consulta en la misma fecha y hora
        Optional<Consulta> consultaExistente =
                consultaRepositorio.findByFechaAndHora(
                        consulta.getFecha(),
                        consulta.getHora());

        if (consultaExistente.isPresent()) {
            throw new RuntimeException(
                "Ya existe una consulta registrada para esa fecha y hora");
        }

        return consultaRepositorio.save(consulta);
    }

    public Consulta buscarConsultaPorId(Long id) {
        return consultaRepositorio.findById(id).orElse(null);
    }

    public void eliminarConsulta(Long id) {
        consultaRepositorio.deleteById(id);
    }

    public Consulta actualizarConsulta(Long id, Consulta consultaActualizada) {

        Consulta consultaExistente =
                consultaRepositorio.findById(id).orElse(null);

        if (consultaExistente != null) {

            consultaExistente.setMedico(consultaActualizada.getMedico());
            consultaExistente.setConsultorio(consultaActualizada.getConsultorio());
            consultaExistente.setPaciente(consultaActualizada.getPaciente());
            consultaExistente.setMotivo(consultaActualizada.getMotivo());
            consultaExistente.setFecha(consultaActualizada.getFecha());
            consultaExistente.setHora(consultaActualizada.getHora());
            consultaExistente.setEstado(consultaActualizada.getEstado());
            consultaExistente.setCosto(consultaActualizada.getCosto());

            return consultaRepositorio.save(consultaExistente);
        }

        return null;
    }

    public Optional<List<Consulta>> buscarPorFecha(Date fecha) {
        return consultaRepositorio.findByFecha(fecha);
    }

    public Optional<Consulta> buscarPorFechaYHora(Date fecha, Time hora) {
        return consultaRepositorio.findByFechaAndHora(fecha, hora);
    }
}