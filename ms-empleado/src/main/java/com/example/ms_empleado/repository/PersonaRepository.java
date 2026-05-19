package com.example.ms_empleado.repository;

import com.example.ms_empleado.model.Pesona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Pesona, Integer> {
 //Agregar métodos personalizados si es necesario
}
