package com.geekshubs.patienthistory.app.services;

import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryException;

public interface PatientLineHistoryService {

    public PatientLineHistory save(final String patientUUID, final PatientLineHistory patientLineHistory) throws PatientHistoryException;
}
