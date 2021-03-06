package com.geekshubs.microservice.app.services.factories;

import com.geekshubs.microservice.domain.entities.Patient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class FactoryPatients {

    private static List<Patient> toList() {
        final var patient = new Patient("nombre", "appellidos", LocalDate.now(), new Date());
        return Arrays.asList(
                patient,
                null,
                patient);
    }

    public static Stream<Patient> toStream() {
        return toList().stream();
    }
}
