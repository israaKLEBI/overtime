package com.overtime.repository;

import com.overtime.model.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TarifRepository extends JpaRepository<Tarif, Long> {
    Optional<Tarif> findByTypeJour(String typeJour);
}