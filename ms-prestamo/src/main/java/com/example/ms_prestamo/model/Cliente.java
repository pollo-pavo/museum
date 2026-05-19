package com.example.ms_prestamo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;        

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column(nullable = false)
    private String nombre;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "prestamo_id")
    private Prestamo prestamo;
}
