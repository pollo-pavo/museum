package com.example.ms_autor.Controller;

import com.example.ms_autor.Model.Autor;
import com.example.ms_autor.Service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/autores")

public class AutorController {
    @Autowired
    private AutorService service;


    @DeleteMapping("/{id}")
    public String eliminarAutor(@PathVariable Integer id) {
        return service.deleteById(id);
    }
    
    @PostMapping
    public ResponseEntity<Autor> crear(@RequestBody Autor aut) {
        Autor nuevoAutor = service.save(aut);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerDetalleCompleto(@PathVariable Integer id) {
        Map<String, Object> respuesta = service.buscarAutorCompleto(id);
        
        if (respuesta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public List<Autor> obtenerAutor() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Autor actualizarAutor(@PathVariable Integer id, @RequestBody Autor aut) {

        return service.update(id, aut);
    }
}

