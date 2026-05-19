package com.example.ms_empleado.service;

import com.example.ms_empleado.client.EmpleadoDeignClient;
import com.example.ms_empleado.model.DTO.CargoDTO;
import com.example.ms_empleado.model.Empleado;
import com.example.ms_empleado.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Autowired
    private EmpleadoDeignClient cargoClient;

    public Empleado save(Empleado empleado) {
        if(empleado.getPersona() != null) {
            empleado.getPersona().setEmpleado(empleado);
        }
        return repository.save(empleado);
    }

    public Map<String, Object> findEmpleado(Integer id){
        Empleado empleado = repository.findById(id).orElse(null);
        Map<String, Object> respuesta = new HashMap<>();

        if(empleado != null){
            List<CargoDTO> cargo = empleado.getCargoIds().stream()
                    .map(cargoId -> cargoClient.getCargoById(cargoId))
                    .collect(Collectors.toList());

            respuesta.put("id", empleado.getId());
            respuesta.put("fechaContrato", empleado.getFechaContrato());
            respuesta.put("persona", empleado.getPersona());
            respuesta.put("cargos", cargo);        
        }
        return respuesta;
    }
}
