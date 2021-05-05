package com.geekshubs.patienthistory.infrastructure.ui.rest;

import com.geekshubs.patienthistory.app.services.PatientHistoryService;
import com.geekshubs.patienthistory.app.services.PatientLineHistoryService;
import com.geekshubs.patienthistory.domain.entities.PatientHistory;
import com.geekshubs.patienthistory.domain.entities.PatientLineHistory;
import com.geekshubs.patienthistory.domain.exceptions.PatientHistoryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/patients")
public class PatientHistoryController {

    private Logger logger = LoggerFactory.getLogger(PatientHistoryController.class);
    private PatientLineHistoryService patientLineHistoryService;
    private PatientHistoryService patientHistoryService;

    @Autowired
    public PatientHistoryController(PatientLineHistoryService patientLineHistoryService, PatientHistoryService patientHistoryService) {
        this.patientLineHistoryService = patientLineHistoryService;
        this.patientHistoryService = patientHistoryService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/{uuid}")
    public ResponseEntity<PatientLineHistory> saveLine(@RequestBody PatientLineHistory patientLineHistory,
                                                       @PathVariable("uuid") final String uuid) {

        PatientLineHistory result = null;

        try {
            return new ResponseEntity<>(patientLineHistoryService.save(uuid, patientLineHistory), HttpStatus.OK);
        } catch (PatientHistoryNotFoundException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllHistory/{uuid}")
    public Flux<PatientHistory> getAllHistory(@PathVariable("uuid") final String uuid) {

        return Flux.just(patientHistoryService.getAllHistoryByUUID(uuid));
    }
}
