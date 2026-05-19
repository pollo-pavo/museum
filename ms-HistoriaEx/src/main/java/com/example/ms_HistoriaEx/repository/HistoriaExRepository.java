package com.example.ms_HistoriaEx.repository;

import com.example.ms_HistoriaEx.model.HistoriaEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaExRepository extends JpaRepository<HistoriaEx, Integer> {
    //Agregar métodos personalizados si es necesario
}
