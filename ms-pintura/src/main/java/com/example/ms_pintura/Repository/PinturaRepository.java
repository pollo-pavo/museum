package com.example.ms_pintura.Repository;

import com.example.ms_pintura.Model.Pintura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinturaRepository extends JpaRepository<Pintura, Integer> {

    

}
