package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@RestController
public class ReportingStructureController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    private ReportingStructureService reportingService;

    @PostMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id){
        LOG.debug("Received reporting structure request for id [{}]", id);

        return reportingService.read(id);
    }
}
