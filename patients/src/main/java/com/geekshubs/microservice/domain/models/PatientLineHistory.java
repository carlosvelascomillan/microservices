package com.geekshubs.microservice.domain.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class PatientLineHistory implements Serializable {

    private static final long serialVersionUID=1L;

    private String uuid = UUID.randomUUID().toString();

    private String acto;

    private String prueba;

    private String doctor;

    private Date dateCreated;

    private String cabUuid;
}
