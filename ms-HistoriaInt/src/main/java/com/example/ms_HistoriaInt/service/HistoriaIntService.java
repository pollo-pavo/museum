package com.example.ms_HistoriaInt.service;

import com.example.ms_HistoriaInt.model.HistoriaInt;
import com.example.ms_HistoriaInt.repository.HistoriaIntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaIntService {

    @Autowired
    private HistoriaIntRepository repository;

    public HistoriaInt finById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public HistoriaInt saveHistoriaInt(HistoriaInt inta){
        return repository.save(inta);
    }

    public List<HistoriaInt> findAll() {
        return repository.findAll();
    }

    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Historia Interactiva eliminada exitosamente";
        }
        return "Historia Interactiva no encontrada";
    }

    public HistoriaInt update(Integer id, HistoriaInt inta) {

        HistoriaInt historiaIntElegida = repository.findById(id).orElse(null);

        if (historiaIntElegida != null) {

            historiaIntElegida.setNombre(inta.getNombre());
            historiaIntElegida.setAutor(inta.getAutor());
            historiaIntElegida.setGenero(inta.getGenero());

            return repository.save(historiaIntElegida);
        }

        return null;
    }
}

   
