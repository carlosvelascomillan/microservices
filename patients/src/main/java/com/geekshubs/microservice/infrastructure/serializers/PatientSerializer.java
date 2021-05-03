package com.geekshubs.microservice.infrastructure.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekshubs.microservice.domain.entities.Patient;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientSerializer implements Serializer<Patient> {

    private Logger logger = LoggerFactory.getLogger(PatientSerializer.class);

    @Override
    public byte[] serialize(String s, Patient patient) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            retVal = objectMapper.writeValueAsString(patient).getBytes();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return retVal;
    }
}
