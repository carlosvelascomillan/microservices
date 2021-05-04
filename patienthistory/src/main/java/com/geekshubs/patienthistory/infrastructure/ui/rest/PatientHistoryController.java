package com.geekshubs.patienthistory.infrastructure.ui.rest;

import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientHistoryController {

    @PostMapping("/{uuid}")
    public ResponseEntity<PatientLineHistory> saveLine(@RequestBody PatientLineHistory patientLineHistory,
                                                       @PathVariable("uuid") final String uuid) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
