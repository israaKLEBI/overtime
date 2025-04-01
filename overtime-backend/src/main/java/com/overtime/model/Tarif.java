package com.overtime.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String typeJour; // "weekend" ou "jour ordinaire"
    private float tarif;

    // Ajoutez ce constructeur
    public Tarif(String typeJour, float tarif) {
        this.typeJour = typeJour;
        this.tarif = tarif;
    }
}