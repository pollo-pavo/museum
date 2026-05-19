package com.example.ms_cargo.repository;

import com.example.ms_cargo.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    //Agregar métodos personalizados si es necesario
}
