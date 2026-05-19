package com.example.ms_autor.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="autor")

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private Integer edad;

    @Column(nullable=false, unique=true)
    private String rut;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "autor_obra",
        joinColumns = @JoinColumn(name = "autor_id"),
        inverseJoinColumns = @JoinColumn(name = "obra_id")
    )
    private List<Obra> obras;

    @ElementCollection
    @CollectionTable(
            name = "autor_pintura_ids",
            joinColumns = @JoinColumn(name = "autor_id")
    )
    @Column(name = "pintura_id")
    private List<Integer> pinturasIds;

    @ElementCollection
    @CollectionTable(
            name = "autor_escultura_ids",
            joinColumns = @JoinColumn(name = "autor_id")
    )
    @Column(name = "escultura_id")
    private List<Integer> esculturasIds;
    

}
