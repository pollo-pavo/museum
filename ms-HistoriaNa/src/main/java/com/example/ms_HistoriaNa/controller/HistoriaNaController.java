package com.example.ms_HistoriaNa.controller;

import com.example.ms_HistoriaNa.model.HistoriaNa;
import com.example.ms_HistoriaNa.service.HistoriaNaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/v1/historia-na")
public class HistoriaNaController {

    @Autowired
    private HistoriaNaService service;

    @GetMapping("/{id}")
    public HistoriaNa getHistoriaNaById(@PathVariable Integer id) {
        return service.finById(id);
    }

    @GetMapping
    public List<HistoriaNa> obtenerHistoriaNa() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<HistoriaNa> crear(@RequestBody HistoriaNa na) {
        HistoriaNa nuevaHistoriaNa = service.saveHistoriaNa(na);
        return new ResponseEntity<>(nuevaHistoriaNa, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarHistoriaNa(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public HistoriaNa actualizarHistoriaNa(@PathVariable Integer id, @RequestBody HistoriaNa na) {

        return service.update(id, na);
    }

}
