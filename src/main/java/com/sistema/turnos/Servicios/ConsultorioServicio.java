package com.sistema.turnos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.turnos.Entidades.Consultorio;
import com.sistema.turnos.Repositorios.ConsultorioRepositorio;

@Service
public class ConsultorioServicio {

    @Autowired
    private ConsultorioRepositorio consultorioRepositorio;

    public List<Consultorio> listarConsultorios() {
        return consultorioRepositorio.findAll();
    }

    public Consultorio guardarConsultorio(Consultorio consultorio) {
        return consultorioRepositorio.save(consultorio);
    }

    public void eliminarConsultorio(Long id) {
        consultorioRepositorio.deleteById(id);
    }

    public Consultorio buscarConsultorioPorId(Long id) {
        return consultorioRepositorio.findById(id).orElse(null);
    }

    public Consultorio actualizarConsultorio(Long id, Consultorio consultorioActualizado) {

        Consultorio consultorioExistente = consultorioRepositorio.findById(id).orElse(null);

        if (consultorioExistente != null) {
            consultorioExistente.setNombre(consultorioActualizado.getNombre());
            consultorioExistente.setUbicacion(consultorioActualizado.getUbicacion());
            consultorioExistente.setEstado(consultorioActualizado.getEstado());

            return consultorioRepositorio.save(consultorioExistente);
        }

        return null;
    }
}