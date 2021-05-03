package com.geekshubs.patienthistory.app.services;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryException;
import com.geekshubs.patienthistory.domain.repositories.PatientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private PatientHistoryRepository patientHistoryRepository;

    private static final String TOPIC = "patients";

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository) {
        this.patientHistoryRepository = patientHistoryRepository;
    }

    @Override
    public void save(PatientHistory patientHistory) throws PatientHistoryException {

        try {
            patientHistoryRepository.save(patientHistory);
        } catch (Exception e) {
            throw new PatientHistoryException(e.getMessage());
        }
    }
}
