package com.restservice.services;

import com.restservice.models.Measurements;
import com.restservice.models.Sensor;
import com.restservice.repositories.MeasurementsRepository;
import com.restservice.util.exceptions.SensorNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final SensorService sensorService;

    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorService sensorService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorService = sensorService;
    }

    public List<Measurements> getAllMeasurements(){
        return measurementsRepository.findAll();
    }

    public Integer getSumOfDaysWithRain(){
        return measurementsRepository.getAllMeasurementsWithRain();
    }

    @Transactional(readOnly = false)
    public void saveNewMeasurements(Measurements measurements){

        if(sensorService.getSensorByName(measurements.getSensor().getName()).isPresent()){
        enrichMeasurement(measurements);
        measurementsRepository.save(measurements);}
        else{
            throw new SensorNotFoundException();
        }
    }
    public void enrichMeasurement(Measurements measurements){
        measurements.setSensor(sensorService.getSensorByName(measurements.getSensor().getName()).get());
    }
}