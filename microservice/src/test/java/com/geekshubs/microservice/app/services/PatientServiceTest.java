package com.geekshubs.microservice.app.services;

import com.geekshubs.microservice.domain.entities.Patient;
import com.geekshubs.microservice.domain.exceptions.PatientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void addPatientTest() throws PatientException {
        Patient patient = new Patient("Pepe",
                "Manuel",
                LocalDate.now(),
                new Date());

        Patient result = patientService.savePatient(patient);
        assertEquals(patient.getName(), result.getName());
    }
}