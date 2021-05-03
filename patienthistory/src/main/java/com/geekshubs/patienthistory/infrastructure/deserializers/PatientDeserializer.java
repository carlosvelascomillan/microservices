package com.geekshubs.patienthistory.infrastructure.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekshubs.patienthistory.domain.models.Patient;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDeserializer implements Deserializer {

    private Logger logger = LoggerFactory.getLogger(PatientDeserializer.class);

    @Override
    public Patient deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Patient patient = null;
        try {
            patient = mapper.readValue(bytes, Patient.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return patient;
    }
}
