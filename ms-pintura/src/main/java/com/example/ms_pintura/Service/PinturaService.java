package com.example.ms_pintura.Service;

import com.example.ms_pintura.Repository.PinturaRepository;
import com.example.ms_pintura.Model.Pintura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PinturaService {

    @Autowired
    private PinturaRepository repository;

    public Pintura findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Pintura savePintura(Pintura pint){
        return repository.save(pint);
    }

    public List<Pintura> findAll() {
        return repository.findAll();
    }


    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Pintura eliminada exitosamente";
        }
        return "Pintura no encontrada";
    }

    public Pintura update(Integer id, Pintura updPint) {

        Pintura pinturaElegida = repository.findById(id).orElse(null);

        if (pinturaElegida != null) {

            pinturaElegida.setTitulo(updPint.getTitulo());
            pinturaElegida.setTecnica(updPint.getTecnica());

            return repository.save(pinturaElegida);
        }

        return null;
    }

}
