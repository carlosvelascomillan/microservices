package com.geekshubs.patienthistory.infrastructure.ui.rest;

import com.geekshubs.patienthistory.app.services.PatientLineHistoryService;
import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientHistoryController {

    private Logger logger = LoggerFactory.getLogger(PatientHistoryController.class);
    private PatientLineHistoryService patientLineHistoryService;

    @Autowired
    public PatientHistoryController(PatientLineHistoryService patientLineHistoryService) {
        this.patientLineHistoryService = patientLineHistoryService;
    }

    @GetMapping("/home")
    public ResponseEntity<Void> home() {
        return new ResponseEntity("Es una prueba", HttpStatus.OK);
    }

    @PostMapping("/{uuid}")
    public ResponseEntity<PatientLineHistory> saveLine(@RequestBody PatientLineHistory patientLineHistory,
                                                       @PathVariable("uuid") final String uuid) {

        PatientLineHistory result = null;

        try {
            return new ResponseEntity<>(patientLineHistoryService.save(uuid, patientLineHistory), HttpStatus.OK);
        } catch (PatientHistoryException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
