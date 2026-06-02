package com.sistema.turnos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sistema.turnos.Entidades.Especialida;
import com.sistema.turnos.Repositorios.EspecialidadRepositorio;

@Service
public class EspecialidadServicio {
    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;

    public List<Especialida> listarEspecialidades() {
        return especialidadRepositorio.findAll();
    }
    public Especialida guardarEspecialidad(Especialida especialidad) {
        return especialidadRepositorio.save(especialidad);
    }
}
