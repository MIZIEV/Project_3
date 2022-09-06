package com.restservice.services;

import com.restservice.models.Measurements;
import com.restservice.repositories.MeasurementsRepository;
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

    @Transactional(readOnly = false)
    public Measurements saveNewMeasurements(Measurements measurements){
        enrichMeasurement(measurements);
        return measurementsRepository.save(measurements);
    }

    public void enrichMeasurement(Measurements measurements){
        measurements.setSensor(sensorService.getSensorByName(measurements.getSensor().getName()).get());
    }
}
