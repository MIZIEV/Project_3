package com.restservice.util.validators;

import com.restservice.dto.MeasurementsDTO;
import com.restservice.services.MeasurementsService;
import com.restservice.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementDTOValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementDTOValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementsDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementsDTO measurementsDTO = (MeasurementsDTO) target;
        if(sensorService.getSensorByName(measurementsDTO.getSensor().getName()).isEmpty()){
            errors.rejectValue("name","","This sensor hasn't registered!!!");
        }
    }
}
