package com.example.ms_biblioteca.controller;

import com.example.ms_biblioteca.model.Libro;
import com.example.ms_biblioteca.service.BibliotecaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/v1/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;

    @GetMapping("/{id}")
    public Libro buscarPorId(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Libro> obtenerLibro() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro lib) {
        Libro nuevoLibro = service.saveLibro(lib);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Integer id, @RequestBody Libro lib) {

        return service.update(id, lib);
    }
}
