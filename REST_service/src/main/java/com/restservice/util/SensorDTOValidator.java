package com.restservice.util;

import com.restservice.dto.SensorDTO;
import com.restservice.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorDTOValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorDTOValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;

        if(sensorService.getSensorByName(sensorDTO.getName()).isPresent()){
            errors.rejectValue("name","","This sensor already exists!!!");
        }
    }
}