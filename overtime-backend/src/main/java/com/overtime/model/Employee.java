package com.overtime.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private String poste;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<HeuresSup> heuresSups;
}