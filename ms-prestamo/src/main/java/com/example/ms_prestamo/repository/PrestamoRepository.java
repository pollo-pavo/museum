package com.example.ms_prestamo.repository;

import com.example.ms_prestamo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    //Agregar métodos personalizados si es necesario    
}
