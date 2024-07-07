package com.example.unitstore.controller;

import com.example.unitstore.entity.Unit;
import com.example.unitstore.service.UnitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/unitHome")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/saveUnit")
    public Unit saveUnit(@RequestBody Unit unit){
        return unitService.saveUnit(unit);
    }

    @GetMapping("/displayUnit")
    public Unit displayUnit(){
        return unitService.displayUnit();
    }



}
