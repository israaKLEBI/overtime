package com.overtime.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class HeuresSup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date;
    private float nbHeures;
    
    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employee employee;
}