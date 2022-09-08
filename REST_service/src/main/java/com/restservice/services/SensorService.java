package com.restservice.services;

import com.restservice.models.Sensor;
import com.restservice.repositories.SensorRepository;
import com.restservice.util.exceptions.SensorAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository repository;

    @Autowired
    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public List<Sensor> getAllSensors() {
        return repository.findAll();
    }

    public Optional<Sensor> getSensorByName(String name) {
        return repository.findByName(name);
    }

    @Transactional(readOnly = false)
    public void addNewSensor(Sensor sensor) {

        if (repository.findByName(sensor.getName()).isPresent()) {
            throw new SensorAlreadyExistsException();
        } else {
            repository.save(sensor);
        }
    }
}