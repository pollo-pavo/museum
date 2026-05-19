package com.example.ms_empleado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer fechaContrato;

    @JsonManagedReference
    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Pesona persona;

    @ElementCollection
    @CollectionTable(
        name = "empleado_cargo",
        joinColumns = @JoinColumn(name = "empleado_id")
    )
    @Column(name = "cargo_id")
    private List<Integer> cargoIds;
    
}
