package com.example.ms_escultura.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;

import com.example.ms_escultura.Model.Escultura;
import com.example.ms_escultura.Service.EsculturaService;

@RestController
@RequestMapping("/api/v1/esculturas")

public class EsculturaController {

    @Autowired
    private EsculturaService service;

    @GetMapping("/{id}")
    public Escultura buscarPorId(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Escultura> obtenerEscultura() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Escultura> crear(@RequestBody Escultura escu) {
        Escultura nuevaEscultura = service.saveEscultura(escu);
        return new ResponseEntity<>(nuevaEscultura, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarEscultura(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Escultura actualizarEscultura(@PathVariable Integer id, @RequestBody Escultura pint) {

        return service.update(id, pint);
    }
}
