package com.sistema.turnos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.turnos.Entidades.Paciente;
import com.sistema.turnos.Repositorios.PacienteRepositorio;

@Service
public class PacienteServicio {
    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    public List<Paciente> listarPacientes(){
        return pacienteRepositorio.findAll();
    }
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepositorio.save(paciente);
    }
    public void eliminarPaciente(Long id){
        pacienteRepositorio.deleteById(id);
    }
    public Paciente buscarPacientePorId(Long id){
        return pacienteRepositorio.findById(id).orElse(null);
    }
    public Paciente actualizarPaciente(Long id, Paciente pacienteActualizado){
        Paciente pacienteExistente = pacienteRepositorio.findById(id).orElse(null);
        if (pacienteExistente != null) {
            pacienteExistente.setNombre(pacienteActualizado.getNombre());
            pacienteExistente.setApellido(pacienteActualizado.getApellido());
            pacienteExistente.setCedula(pacienteActualizado.getCedula());
            pacienteExistente.setGenero(pacienteActualizado.getGenero());
            return pacienteRepositorio.save(pacienteExistente);
        }
        return pacienteActualizado;
    }
}
