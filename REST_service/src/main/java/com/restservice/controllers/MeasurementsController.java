package com.restservice.controllers;

import com.restservice.dto.MeasurementsDTO;
import com.restservice.models.Measurements;
import com.restservice.services.MeasurementsService;
import com.restservice.util.errorresponces.ErrorResponse;
import com.restservice.util.exceptions.SensorNotFoundException;
import com.restservice.util.validators.MeasurementDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/api/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;
    private final MeasurementDTOValidator measurementDTOValidator;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService,
                                  MeasurementDTOValidator measurementDTOValidator) {
        this.measurementsService = measurementsService;
        this.measurementDTOValidator = measurementDTOValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewMeasurements(@RequestBody @Valid MeasurementsDTO measurementsDTO,
                                                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            StringBuffer stringBuffer = new StringBuffer();
            List<FieldError> errors = bindingResult.getFieldErrors();

            for(FieldError error : errors){
                stringBuffer.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }
            throw  new SensorNotFoundException(stringBuffer.toString());
        }
        measurementsService.saveNewMeasurements(convertToMeasurement(measurementsDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> weatherDataHandler(SensorNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                "Sensor doesn't registered. Register them.", System.currentTimeMillis()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    private Measurements convertToMeasurement(MeasurementsDTO measurementsDTO) {

        Measurements measurements = new Measurements();
        measurements.setTemperature(measurementsDTO.getTemperature());
        measurements.setRain(measurementsDTO.isRain());
        measurements.setSensor(measurementsDTO.getSensor());

        return measurements;
    }
}