package com.geekshubs.patienthistory.domain.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "HISTORYLINES")
@Data
public class PatientLineHistory {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "uuid", length = 16, unique = true, nullable = false, insertable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column
    private String acto;

    @Column
    private String prueba;

    @Column
    private String doctor;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated;

    @Column(name="cab_uuid")
    private String cabUuid;

    public PatientLineHistory() {
    }

    public PatientLineHistory(String acto, String prueba, String doctor) {
        this.acto = acto;
        this.prueba = prueba;
        this.doctor = doctor;
    }

}
