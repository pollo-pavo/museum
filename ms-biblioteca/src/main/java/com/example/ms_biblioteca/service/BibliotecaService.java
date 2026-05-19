package com.example.ms_biblioteca.service;

import com.example.ms_biblioteca.model.Libro;
import com.example.ms_biblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository repository;

    public Libro findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Libro saveLibro(Libro lib){
        return repository.save(lib);
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Libro eliminado exitosamente";
        }
        return "Libro no encontrado";
    }

    public Libro update(Integer id, Libro lib) {

        Libro libroElegido = repository.findById(id).orElse(null);

        if (libroElegido != null) {

            libroElegido.setTitulo(lib.getTitulo());
            libroElegido.setEscritor(lib.getEscritor());

            return repository.save(libroElegido);
        }

        return null;
    }

}
