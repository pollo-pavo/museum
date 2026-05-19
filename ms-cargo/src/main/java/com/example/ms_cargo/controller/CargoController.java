package com.example.ms_cargo.controller;

import com.example.ms_cargo.model.Cargo;
import com.example.ms_cargo.service.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cargo")
public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping("/{id}")
    public Cargo getById(@PathVariable Integer id) {
        return service.findById(id);
    }

        @GetMapping
    public List<Cargo> obtenerCargo() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Cargo> crear(@RequestBody Cargo carg) {
        Cargo nuevoCargo = service.saveCargo(carg);
        return new ResponseEntity<>(nuevoCargo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarCargo(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Cargo actualizarCargo(@PathVariable Integer id, @RequestBody Cargo carg) {

        return service.update(id, carg);
    }
}
