package com.example.ms_cargo.service;

import com.example.ms_cargo.model.Cargo;
import com.example.ms_cargo.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public Cargo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Cargo saveCargo(Cargo carg){
        return repository.save(carg);
    }

    public List<Cargo> findAll() {
        return repository.findAll();
    }

    public String deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Cargo eliminado exitosamente";
        }
        return "Cargo no encontrado";
    }

    public Cargo update(Integer id, Cargo carg) {

        Cargo cargoElegido = repository.findById(id).orElse(null);

        if (cargoElegido != null) {
            cargoElegido.setNombre(carg.getNombre());

            return repository.save(cargoElegido);
        }

        return null;
    }

}
