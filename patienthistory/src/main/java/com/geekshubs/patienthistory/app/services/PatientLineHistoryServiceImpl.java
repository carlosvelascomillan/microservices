package com.geekshubs.patienthistory.app.services;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryNotFoundException;
import com.geekshubs.patienthistory.domain.repositories.PatientHistoryRepository;
import com.geekshubs.patienthistory.domain.repositories.PatientLineHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PatientLineHistoryServiceImpl implements PatientLineHistoryService {

    private PatientLineHistoryRepository patientLineHistoryRepository;
    private PatientHistoryRepository patientHistoryRepository;

    @Autowired
    public PatientLineHistoryServiceImpl(PatientLineHistoryRepository patientLineHistoryRepository,
                                         PatientHistoryRepository patientHistoryRepository) {
        this.patientLineHistoryRepository = patientLineHistoryRepository;
        this.patientHistoryRepository = patientHistoryRepository;
    }

    @Override
    public PatientLineHistory save(String patientUUID, PatientLineHistory patientLineHistory) throws PatientHistoryNotFoundException {
        PatientHistory patientHistory = patientHistoryRepository.findByPatientUUID(patientUUID);

        if (patientHistory == null) {
            throw new PatientHistoryNotFoundException("History not found");
        }

        patientLineHistory.setCabUuid(patientHistory.getUuid());
        patientLineHistory.setDateCreated(new Date());
        return patientLineHistoryRepository.save(patientLineHistory);
    }
}
