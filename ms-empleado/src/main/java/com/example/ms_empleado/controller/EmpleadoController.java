package com.example.ms_empleado.controller;

import com.example.ms_empleado.model.Empleado;
import com.example.ms_empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @PostMapping
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = service.save(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findEmpleado(@PathVariable Integer id) {
        Map<String, Object> respuesta = service.findEmpleado(id);
        if (respuesta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

}
