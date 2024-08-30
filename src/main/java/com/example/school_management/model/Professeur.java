package com.example.school_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data


public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;

    @ManyToMany(mappedBy = "professeurs")
    private Set<Cours> cours = new HashSet<>();;
}
