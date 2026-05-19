package com.example.ms_pintura.Controller;

import com.example.ms_pintura.Model.Pintura;
import com.example.ms_pintura.Service.PinturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/v1/pinturas")

public class PinturaController {

    @Autowired
    private PinturaService service;

    @GetMapping("/{id}")
    public Pintura buscarPorId(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Pintura> obtenerPintura() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Pintura> crear(@RequestBody Pintura pint) {
        Pintura nuevaPintura = service.savePintura(pint);
        return new ResponseEntity<>(nuevaPintura, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarPintura(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Pintura actualizarPintura(@PathVariable Integer id, @RequestBody Pintura pint) {

        return service.update(id, pint);
    }
}
