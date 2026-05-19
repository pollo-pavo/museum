package com.example.ms_HistoriaNa.repository;

import com.example.ms_HistoriaNa.model.HistoriaNa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaNaRepository extends JpaRepository<HistoriaNa, Integer> {
    //Agregar métodos personalizados si es necesario    

}
