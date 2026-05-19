package com.example.ms_autor.Repository;

import com.example.ms_autor.Model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer>{

}
