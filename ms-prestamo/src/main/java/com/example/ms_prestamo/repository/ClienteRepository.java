package com.example.ms_prestamo.repository;

import com.example.ms_prestamo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    //Agregar métodos personalizados si es necesario
}
