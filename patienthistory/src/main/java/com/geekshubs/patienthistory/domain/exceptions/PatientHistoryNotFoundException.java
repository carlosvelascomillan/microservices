package com.geekshubs.patienthistory.domain.exceptions;

public class PatientHistoryNotFoundException extends RuntimeException {

    public PatientHistoryNotFoundException(final String message) {
        super(message);
    }
}
