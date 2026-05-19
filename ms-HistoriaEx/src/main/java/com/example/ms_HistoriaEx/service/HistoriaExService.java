package com.example.ms_HistoriaEx.service;

import com.example.ms_HistoriaEx.model.HistoriaEx;
import com.example.ms_HistoriaEx.repository.HistoriaExRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaExService {

    @Autowired
    private HistoriaExRepository repository;

    public HistoriaEx finById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    
    public HistoriaEx saveHistoriaEx(HistoriaEx ex){
        return repository.save(ex);
    }

    public List<HistoriaEx> findAll() {
        return repository.findAll();
    }

    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Historia Extranjera eliminada exitosamente";
        }
        return "Historia Extranjera no encontrada";
    }

    public HistoriaEx update(Integer id, HistoriaEx ex) {

        HistoriaEx historiaExElegida = repository.findById(id).orElse(null);

        if (historiaExElegida != null) {

            historiaExElegida.setNombre(ex.getNombre());
            historiaExElegida.setAutor(ex.getAutor());
            historiaExElegida.setGenero(ex.getGenero());

            return repository.save(historiaExElegida);
        }

        return null;
    }
}
