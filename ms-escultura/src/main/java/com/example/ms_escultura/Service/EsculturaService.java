package com.example.ms_escultura.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_escultura.Model.Escultura;
import com.example.ms_escultura.Repository.EsculturaRepository;

import java.util.List;

@Service
public class EsculturaService {

    @Autowired
    private EsculturaRepository repository;

    public Escultura findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Escultura saveEscultura(Escultura pint){
        return repository.save(pint);
    }

    public List<Escultura> findAll() {
        return repository.findAll();
    }


    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Escultura eliminada exitosamente";
        }
        return "Escultura no encontrada";
    }

    public Escultura update(Integer id, Escultura updEsc) {

        Escultura esculturaElegida = repository.findById(id).orElse(null);

        if (esculturaElegida != null) {

            esculturaElegida.setTitulo(updEsc.getTitulo());
            esculturaElegida.setAltura(updEsc.getAltura());

            return repository.save(esculturaElegida);
        }

        return null;
    }

}
