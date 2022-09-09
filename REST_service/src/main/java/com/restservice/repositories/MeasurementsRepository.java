package com.restservice.repositories;

import com.restservice.models.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements,Integer> {

    @Query("SELECT count (isRain) FROM Measurements where isRain=true")
    public Integer getAllMeasurementsWithRain();
}
