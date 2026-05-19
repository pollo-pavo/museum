package com.example.ms_prestamo.controller;

import com.example.ms_prestamo.client.BibliotecaFeignClient;
import com.example.ms_prestamo.model.Prestamo;
import com.example.ms_prestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService service;

    @Autowired
    private BibliotecaFeignClient bibliotecaClient;

    @PostMapping
    public ResponseEntity<Prestamo> save(@RequestBody Prestamo prestamo){
        Prestamo nuevoPrestamo = service.save(prestamo);
        return new ResponseEntity<>(nuevoPrestamo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscarPrestamo(@PathVariable Integer id){
        Map<String, Object> respuesta = service.buscarPrestamo(id);
        if(respuesta.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }
}
