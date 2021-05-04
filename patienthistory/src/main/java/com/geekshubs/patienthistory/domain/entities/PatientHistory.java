package com.geekshubs.patienthistory.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PATIENTHISTORY")
@Data
public class PatientHistory implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "uuid", length = 16, unique = true, nullable = false, insertable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_last_name")
    private String patientLastName;

    @Column(name = "patient_uuid")
    private String patientUUID;

    @Column
    private String doctor;

    @Column
    private String specialty;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_uuid")
    private List<PatientLineHistory> patientLineHistory;

    public PatientHistory() {
    }

    public PatientHistory(String patientName, String patientLastName, String patientUUID, String doctor, String specialty) {
        this.patientName = patientName;
        this.patientLastName = patientLastName;
        this.patientUUID = patientUUID;
        this.doctor = doctor;
        this.specialty = specialty;
    }
}
