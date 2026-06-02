package com.sistema.turnos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.turnos.Entidades.Genero;
import com.sistema.turnos.Repositorios.GeneroRepositorio;

@Service
public class GeneroServicio {
    @Autowired 
    private GeneroRepositorio generoRepositorio;

    public List<Genero> listarGeneros(){
        return generoRepositorio.findAll();
    }
    public Genero guardarGenero(Genero genero){
        return generoRepositorio.save(genero);
    }
    public void eliminarGenero(Long id){
        generoRepositorio.deleteById(id);
    }
    public Genero buscarGeneroPorId(Long id){
        return generoRepositorio.findById(id).orElse(null);
    }
    public Genero actualizarGenero(Long id, Genero generoActualizado){
        Genero generoExistente = generoRepositorio.findById(id).orElse(null);
        if (generoExistente != null) {
            generoExistente.setNombre(generoActualizado.getNombre());
            return generoRepositorio.save(generoExistente);
        }
        return null;
    }
}
