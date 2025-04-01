package com.overtime.service;

import com.overtime.model.*;
import com.overtime.repository.HeuresSupRepository;
import com.overtime.repository.TarifRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OvertimeService {
    private final HeuresSupRepository heuresSupRepository;
    private final TarifRepository tarifRepository;

    public OvertimeCalculation calculateOvertime(Long employeeId, LocalDate startDate, LocalDate endDate) {
        List<HeuresSup> heures = heuresSupRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
        
        Tarif tarifOrdinaire = tarifRepository.findByTypeJour("jour ordinaire")
                .orElse(new Tarif("jour ordinaire", 1.25f));
        Tarif tarifWeekend = tarifRepository.findByTypeJour("weekend")
                .orElse(new Tarif("weekend", 1.5f));
        
        float totalHeures = 0;
        float montantTotal = 0;
        
        for (HeuresSup hs : heures) {
            boolean isWeekend = hs.getDate().getDayOfWeek() == DayOfWeek.SATURDAY 
                    || hs.getDate().getDayOfWeek() == DayOfWeek.SUNDAY;
            
            float tarif = isWeekend ? tarifWeekend.getTarif() : tarifOrdinaire.getTarif();
            float montant = hs.getNbHeures() * tarif;
            
            totalHeures += hs.getNbHeures();
            montantTotal += montant;
        }
        
        return new OvertimeCalculation(totalHeures, montantTotal);
    }
}