package com.geekshubs.patienthistory.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Patient {

    private static final long serialVersionUID=1L;

    private String uuid;

    private String name;

    private String lastName;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    private Date dateCreated;

    public Patient() {
    }

    public Patient(String name, String lastName, LocalDate birthDate, Date dateCreated) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.dateCreated = dateCreated;
    }
}
