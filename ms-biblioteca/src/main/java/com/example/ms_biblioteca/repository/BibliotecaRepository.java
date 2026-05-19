package com.example.ms_biblioteca.repository;

import com.example.ms_biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Libro, Integer> {
    //Agrgar métodos personalizados si es necesario
}
