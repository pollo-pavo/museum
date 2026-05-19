package com.example.ms_escultura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_escultura.Model.Escultura;

@Repository
public interface EsculturaRepository extends JpaRepository<Escultura, Integer> {

    

}
