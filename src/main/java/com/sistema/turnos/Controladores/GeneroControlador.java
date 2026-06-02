package com.sistema.turnos.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.turnos.Entidades.Genero;
import com.sistema.turnos.Servicios.GeneroServicio;

@RestController
@RequestMapping("/api/genero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GeneroControlador {
    @Autowired
    private GeneroServicio generoServicio;

    @PostMapping
    public ResponseEntity<Genero> crearGenero(@RequestBody Genero genero) {
        Genero nuevoGenero = generoServicio.guardarGenero(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGenero);
    }
    @GetMapping
    public ResponseEntity<?> listarGeneros(){
        return ResponseEntity.ok().body(generoServicio.listarGeneros());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerGeneroPorId(@PathVariable Long id){
        Genero genero = generoServicio.buscarGeneroPorId(id);
        if (genero != null) {
            return ResponseEntity.ok().body(genero);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Género no encontrado");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarGenero(@PathVariable Long id){
        generoServicio.eliminarGenero(id);
        return ResponseEntity.ok().body("Género eliminado exitosamente");
    }
    @PutMapping("/{id]")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody Genero generoActualizado){
        Genero genero = generoServicio.actualizarGenero(id, generoActualizado);
        if (genero != null) {
            return ResponseEntity.ok().body(genero);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Género no encontrado");
        }
    }
}
