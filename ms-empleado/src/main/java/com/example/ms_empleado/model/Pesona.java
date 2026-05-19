package com.example.ms_empleado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Pesona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private Integer edad;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

}