package com.restservice.controllers;

import com.restservice.dto.MeasurementsDTO;
import com.restservice.models.Measurements;
import com.restservice.models.Sensor;
import com.restservice.services.MeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
    @Autowired
    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewMeasurements(@RequestBody Measurements measurements) {

        measurementsService.saveNewMeasurements(measurements);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
