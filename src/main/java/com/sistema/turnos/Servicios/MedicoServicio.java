package com.sistema.turnos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.turnos.Entidades.Medico;
import com.sistema.turnos.Repositorios.MedicoRepositorio;

@Service
public class MedicoServicio {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    public List<Medico> listarMedicos() {
        return medicoRepositorio.findAll();
    }

    public Medico guardarMedico(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    public void eliminarMedico(Long id) {
        medicoRepositorio.deleteById(id);
    }

    public Medico buscarMedicoPorId(Long id) {
        return medicoRepositorio.findById(id).orElse(null);
    }

    public Medico actualizarMedico(Long id, Medico medicoActualizado) {
        Medico medicoExistente = medicoRepositorio.findById(id).orElse(null);

        if (medicoExistente != null) {
            medicoExistente.setNombre(medicoActualizado.getNombre());
            medicoExistente.setApellido(medicoActualizado.getApellido());
            medicoExistente.setCedula(medicoActualizado.getCedula());
            medicoExistente.setEspecialidad(medicoActualizado.getEspecialidad());

            return medicoRepositorio.save(medicoExistente);
        }

        return null;
    }
}
