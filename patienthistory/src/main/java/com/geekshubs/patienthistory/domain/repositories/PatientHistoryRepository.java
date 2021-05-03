package com.geekshubs.patienthistory.domain.repositories;

import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHistoryRepository extends CrudRepository<PatientHistory, String> {
}
