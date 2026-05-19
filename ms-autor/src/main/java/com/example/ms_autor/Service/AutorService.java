package com.example.ms_autor.Service;

import com.example.ms_autor.Client.*;
import com.example.ms_autor.Model.Autor;
import com.example.ms_autor.Model.Obra;
import com.example.ms_autor.Model.DTO.EsculturaDTO;
import com.example.ms_autor.Model.DTO.PinturaDTO;
import com.example.ms_autor.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service

public class AutorService {
    @Autowired
    private AutorRepository repository;

    @Autowired
    private PinturaFeignClient pinturaClient;

    @Autowired
    private EsculturaFeignClient esculturaClient;

    public String deleteById(Integer Id){
        if(repository.existsById(Id)){
            repository.deleteById(Id);
            return "Autor eliminado exitosamente";
        }
        return "Autor no encontrado";
    }

    public Autor save(Autor aut) {
        if (aut.getObras() != null) {
            for (Obra obra : aut.getObras()) {
                if (obra.getAutores() == null) {
                    obra.setAutores(new ArrayList<>());
                }
                obra.getAutores().add(aut);
            }
        }
        return repository.save(aut);
    }

    public Map<String, Object> buscarAutorCompleto(Integer id) {
        Autor autor = repository.findById(id).orElse(null);
        Map<String, Object> respuesta = new HashMap<>();

        if (autor != null) {
            List<PinturaDTO> pinturasDetalle = autor.getPinturasIds().stream()
                    .map(pinturaId -> pinturaClient.obtenerPinturaPorId(pinturaId))
                    .collect(Collectors.toList());
            List<EsculturaDTO> esculturasDetalle = autor.getEsculturasIds().stream()
                    .map(esculturaId -> esculturaClient.obtenerEsculturaPorId(esculturaId))
                    .collect(Collectors.toList());

            respuesta.put("id", autor.getId());
            respuesta.put("nombre", autor.getNombre());
            respuesta.put("edad", autor.getEdad());
            respuesta.put("rut", autor.getRut());
            respuesta.put("Pinturas del Autor", pinturasDetalle);
            respuesta.put("Esculturas del Autor", esculturasDetalle);
        }
        return respuesta;
    }

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Autor update(Integer id, Autor updAut) {

    Autor autorElegido = repository.findById(id).orElse(null);

    if (autorElegido != null) {

        autorElegido.setNombre(updAut.getNombre());
        autorElegido.setEdad(updAut.getEdad());
        autorElegido.setRut(updAut.getRut());
        if (updAut.getObras() != null) {
            autorElegido.setObras(updAut.getObras());
        }
        autorElegido.setPinturasIds(updAut.getPinturasIds());
        autorElegido.setEsculturasIds(updAut.getEsculturasIds());

        return repository.save(autorElegido);
    }

    return null;
}

}
