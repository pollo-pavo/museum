package com.example.ms_prestamo.service;

import com.example.ms_prestamo.client.BibliotecaFeignClient;
import com.example.ms_prestamo.model.DTO.BibliotecaDTO;
import com.example.ms_prestamo.model.Prestamo;
import com.example.ms_prestamo.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository repository;

    @Autowired
    private BibliotecaFeignClient bibliotecaClient;

    public Prestamo save(Prestamo prestamo){
        if(prestamo.getCliente() != null){
            prestamo.getCliente().setPrestamo(prestamo);
        }
        return repository.save(prestamo);
    }

    public Map<String, Object> buscarPrestamo(Integer id){
        Prestamo prestamo = repository.findById(id).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if(prestamo != null){
            List<BibliotecaDTO> librosPrestado = prestamo.getLibrosPrestados().stream()
                    .map(libroid -> bibliotecaClient.getLibrosById(libroid))
                    .collect(Collectors.toList());

            response.put("id", prestamo.getId());
            response.put("codigo", prestamo.getCodigo());
            response.put("estado", prestamo.getEstado());
            response.put("cliente", prestamo.getCliente());
            response.put("librosPrestados", librosPrestado);
        }
        return response;
    }
}
