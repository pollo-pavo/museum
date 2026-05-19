package com.example.ms_autor.Client;

import com.example.ms_autor.Model.DTO.PinturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-pintura", url = "http://localhost:8081")

public interface PinturaFeignClient {

    @GetMapping("/api/v1/pinturas/{id}")
    PinturaDTO obtenerPinturaPorId(@PathVariable("id") Integer id);

}
