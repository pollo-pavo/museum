package com.example.ms_HistoriaNa.service;

import com.example.ms_HistoriaNa.model.HistoriaNa;
import com.example.ms_HistoriaNa.repository.HistoriaNaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaNaService {

    @Autowired
    private HistoriaNaRepository repository;

    public HistoriaNa finById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public HistoriaNa saveHistoriaNa(HistoriaNa na){
        return repository.save(na);
    }

    public List<HistoriaNa> findAll() {
        return repository.findAll();
    }

    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Historia Nacional eliminada exitosamente";
        }
        return "Historia Nacional no encontrada";
    }

    public HistoriaNa update(Integer id, HistoriaNa na) {

        HistoriaNa historiaNaElegida = repository.findById(id).orElse(null);

        if (historiaNaElegida != null) {

            historiaNaElegida.setNombre(na.getNombre());
            historiaNaElegida.setAutor(na.getAutor());
            historiaNaElegida.setGenero(na.getGenero());

            return repository.save(historiaNaElegida);
        }

        return null;
    }
}
