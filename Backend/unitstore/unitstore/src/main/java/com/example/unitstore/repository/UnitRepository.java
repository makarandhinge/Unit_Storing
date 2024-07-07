package com.example.unitstore.repository;

import com.example.unitstore.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {


   @Query(value = "SELECT * FROM unitstoring ORDER BY today_date DESC,id DESC LIMIT 1", nativeQuery = true)
   Unit getLastestUnit();

}
