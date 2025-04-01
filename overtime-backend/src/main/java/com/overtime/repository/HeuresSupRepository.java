package com.overtime.repository;

import com.overtime.model.HeuresSup;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface HeuresSupRepository extends JpaRepository<HeuresSup, Long> {
    List<HeuresSup> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}