package com.mindex.challenge.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.data.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

@Service
public class CompensationServiceImpl implements CompensationService {

    @Autowired
    private ObjectMapper objectMapper;

    private static final String FILE_LOCATION = "/../../../../static/compensation.json";

    @Override
    public Compensation create(Employee employee){
        // create compensation object
        Compensation comp = new Compensation();

        // set employee, salary, and effective data
        comp.setEmployee(employee);
        comp.setSalary(0); // where is this data coming from?
        comp.setDate(new Date()); // current Date

        // write to compensation.json file
        objectMapper = new ObjectMapper();

        // try {
        //     FileWriter file = new FileWriter(FILE_LOCATION);
        //     file.write(comp.toString());
        //     file.close();
        //     //objectMapper.writeValue(new File(FILE_LOCATION), comp);
        // } catch (IOException e){
        //     throw new RuntimeException(e);
        // }

        return comp;
    }

    @Override
    public Compensation read(String id){
        InputStream inputStream = this.getClass().getResourceAsStream(FILE_LOCATION);

        Compensation[] comps = null;

        Compensation returnComp = null; // our return value

        // read in JSON file
        try {
            comps = objectMapper.readValue(inputStream, Compensation[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //find matching employee
        for (Compensation comp : comps){
            if (comp.getEmployee().getEmployeeId() == id){
                returnComp = comp;
            }
        }

        return returnComp;

    }

}
