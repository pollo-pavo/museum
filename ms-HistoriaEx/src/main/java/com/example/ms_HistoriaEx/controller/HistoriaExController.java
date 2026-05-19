package com.example.ms_HistoriaEx.controller;

import com.example.ms_HistoriaEx.model.HistoriaEx;
import com.example.ms_HistoriaEx.service.HistoriaExService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.* ;

@RestController
@RequestMapping("/api/v1/historia-ex")
public class HistoriaExController {

    @Autowired
    private HistoriaExService service;

    @GetMapping("/{id}")
    public HistoriaEx getHistoriaEx(@PathVariable Integer id) {
        return service.finById(id);
    }

    @GetMapping
    public List<HistoriaEx> obtenerHistoriaEx() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<HistoriaEx> crear(@RequestBody HistoriaEx ex) {
        HistoriaEx nuevaHistoriaEx = service.saveHistoriaEx(ex);
        return new ResponseEntity<>(nuevaHistoriaEx, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String eliminarHistoriaEx(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public HistoriaEx actualizarHistoriaEx(@PathVariable Integer id, @RequestBody HistoriaEx ex) {

        return service.update(id, ex);
    }

}
