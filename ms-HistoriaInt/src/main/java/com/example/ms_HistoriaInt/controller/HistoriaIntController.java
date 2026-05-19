package com.example.ms_HistoriaInt.controller;

import com.example.ms_HistoriaInt.model.HistoriaInt;
import com.example.ms_HistoriaInt.service.HistoriaIntService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/v1/historia-int")
public class HistoriaIntController {
    
    @Autowired
    private HistoriaIntService service;

    @GetMapping("/{id}")
    public HistoriaInt getHistoriaIntById(@PathVariable Integer id) {
        return service.finById(id);
    }

    @GetMapping
    public List<HistoriaInt> obtenerHistoriaInt() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<HistoriaInt> crear(@RequestBody HistoriaInt inta) {
        HistoriaInt nuevaHistoriaInt = service.saveHistoriaInt(inta);
        return new ResponseEntity<>(nuevaHistoriaInt, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarHistoriaInt(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public HistoriaInt actualizarHistoriaInt(@PathVariable Integer id, @RequestBody HistoriaInt inta) {

        return service.update(id, inta);
    }
}
