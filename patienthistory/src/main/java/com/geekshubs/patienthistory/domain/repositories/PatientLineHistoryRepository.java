package com.geekshubs.patienthistory.domain.repositories;

import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientLineHistoryRepository extends CrudRepository<PatientLineHistory, String> {
}
