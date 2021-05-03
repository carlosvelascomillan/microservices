package com.geekshubs.patienthistory.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PATIENTHISTORY")
public class PatientHistory implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "uuid", length = 16, unique = true, nullable = false)
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

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
