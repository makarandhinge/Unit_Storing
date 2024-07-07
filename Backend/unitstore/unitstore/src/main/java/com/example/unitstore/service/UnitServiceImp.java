package com.example.unitstore.service;

import com.example.unitstore.entity.Unit;
import com.example.unitstore.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UnitServiceImp implements UnitService{

    @Autowired
    private UnitRepository unitRepository;

    public Unit saveUnit(Unit unit){

        Unit savedUnitReading = unitRepository.save(unit);
        Long currentId = savedUnitReading.getId() ;
        Long previewsId = currentId - 1;

        Unit previewsUnitReading = unitRepository.findById(previewsId).orElse(null);
        if(previewsUnitReading != null){
            float unitDifference = savedUnitReading.getUnitreading() - previewsUnitReading.getUnitreading();
            savedUnitReading.setUnit(unitDifference);
            unitRepository.save(savedUnitReading);
        }

        return savedUnitReading;



//        if(unit.getUnitreading() < 0){
//            throw new IllegalArgumentException("Reading cannot be negative");
//        }
//
//        Unit lastestColoumn = unitRepository.getById(unit.getId() - 1);
//        Unit lastUnit = lastestColoumn.getUnitreading();
//
//
//
//        float previousReading = (lastUnit != null) ? lastUnit.getUnitreading() : 0 ;
//
//        float units = unit.getUnitreading() - previousReading;
//
//        unit.setUnit(units);
//
//        unit.setTodayDate(LocalDate.now());
//
//        try {
//            return unitRepository.save(unit);
//        }catch(Exception e ){
//            throw new RuntimeException("Error saving unit Reading", e);
//        }
        }

    @Override
    public Unit displayUnit() {
        return unitRepository.getLastestUnit();
    }


}
