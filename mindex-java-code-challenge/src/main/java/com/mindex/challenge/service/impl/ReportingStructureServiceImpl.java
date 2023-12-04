package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import java.util.ArrayList;
import java.util.List;

public class ReportingStructureServiceImpl implements ReportingStructureService{

     private EmployeeRepository employeeRepository; // used for finding employee by id
     private int finalDirectReports = 0; // total num of directReports found

    public ReportingStructure read(String id){
        // make reporting structure object based on the id passed in
        // find employee object with that id (employee repository has a function for this)
        // find direct reports list
        // directReportNum = length of list by default (if list exists) (global variable?)
        // loop through direct reports list and find direct reports <-- could make a function for this? may have to check for cases where total num is very deeply nested
        // - get length of list
        // - for each object in list, get length of list
        // - if length of list > 0 (list exists), call function again
        // - is this recursion??
        // add length of each found list to directReportNum
        // set object.numDirectReports = final directReportNum


        // until direct reports list stops existing, call function again and pass in list (only gets called if there is a list)
        /* private int getReportNum(List<employee> reports){
            finalNum += reports.size()

            foreach (report in reports){
                if (report.reports exists){
                    getReportNum(report.reports)
                }
            }
            
            return finalNum;
        }
        */

        // make reporting structure object to be returned
        ReportingStructure reportingStructure = new ReportingStructure();

        // find employee by id using employee repository
        Employee employee = employeeRepository.findByEmployeeId(id);

        // set id in reportingStructure
        reportingStructure.setEmployeeId(employee.getEmployeeId());

        // call getFinalNum function
        if (employee.getDirectReports() != null){
            getFinalNum(employee.getDirectReports());
        }

        reportingStructure.setNumOfReports(finalDirectReports);

        return reportingStructure;

    }

    private int getFinalNum(List<Employee> reports){

        // increase final num based on size of list passed in
        finalDirectReports += reports.size();

        // adding up final direct reports num
        for (Employee employee : reports) {
            if (employee.getDirectReports() != null){
                getFinalNum(employee.getDirectReports());
            }
        }

        return finalDirectReports;
    }
}
