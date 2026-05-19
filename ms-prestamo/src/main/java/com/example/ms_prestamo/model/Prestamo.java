package com.example.ms_prestamo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private Boolean estado;

    @JsonManagedReference
    @OneToOne(mappedBy = "prestamo", cascade = CascadeType.ALL)
    private Cliente cliente;

    @ElementCollection
    @CollectionTable(
        name = "prestamo_libros",
        joinColumns = @JoinColumn(name = "prestamo_id")
    )
    @Column(name = "libro_id")
    private List<Integer> librosPrestados;
}
