package com.mindex.challenge.data;

public class ReportingStructure {
    private String employeeId;
    private int numberOfReports;

    public ReportingStructure(){
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public int getNumOfReports(){
        return numberOfReports;
    }

    public void setNumOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
    }
}