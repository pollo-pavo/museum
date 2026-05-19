package com.example.ms_autor.Client;

import com.example.ms_autor.Model.DTO.EsculturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-escultura", url = "http://localhost:8083")

public interface EsculturaFeignClient {

    @GetMapping("/api/v1/esculturas/{id}")
    EsculturaDTO obtenerEsculturaPorId(@PathVariable("id") Integer id);

}
