package com.example.unitstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unitstoring")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "today_date")
    private LocalDate todayDate = LocalDate.now();
    private float unitreading;
    @Column(name = "unit")
    private float unit;


    @PrePersist
    public void setDefaultDate() {
        if (todayDate == null) {
            todayDate = LocalDate.now();
        }
    }
}


