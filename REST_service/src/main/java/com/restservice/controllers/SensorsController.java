package com.restservice.controllers;

import com.restservice.models.Sensor;
import com.restservice.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorsController {

    private final SensorService sensorService;

    @Autowired
    public SensorsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/all")
    public List<Sensor> getJSONWithAllSensors(){
        return sensorService.getAllSensors();
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> addNewSensor(@RequestBody Sensor sensor){
        sensorService.addNewSensor(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}