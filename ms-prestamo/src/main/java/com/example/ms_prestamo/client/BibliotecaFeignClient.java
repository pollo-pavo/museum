package com.example.ms_prestamo.client;

import com.example.ms_prestamo.model.DTO.BibliotecaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-biblioteca", url = "localhost:8802")
public interface BibliotecaFeignClient {

    @GetMapping("/api/v1/bibliotecas/{id}")
    BibliotecaDTO getLibrosById(@PathVariable("id") Integer id);

}
