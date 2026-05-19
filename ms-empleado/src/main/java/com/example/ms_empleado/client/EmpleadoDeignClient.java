package com.example.ms_empleado.client;

import com.example.ms_empleado.model.DTO.CargoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cargo", url = "localhost:8803")
public interface EmpleadoDeignClient {

    @GetMapping("/api/v1/cargo/{id}")
    CargoDTO getCargoById(@PathVariable("id") Integer id);

}
