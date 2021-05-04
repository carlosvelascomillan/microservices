package com.geekshubs.microservice.domain.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PatientHistory implements Serializable {

    private static final long serialVersionUID=1L;

    private String uuid;

    private String patientName;

    private String patientLastName;

    private String patientUUID;

    private String doctor;

    private String specialty;

    private List<PatientLineHistory> patientLineHistory;
}
