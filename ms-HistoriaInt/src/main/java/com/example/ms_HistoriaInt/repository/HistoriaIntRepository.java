package com.example.ms_HistoriaInt.repository;

import com.example.ms_HistoriaInt.model.HistoriaInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaIntRepository extends JpaRepository<HistoriaInt, Integer> {
    //Agregar métodos personalizados si es necesario
}
