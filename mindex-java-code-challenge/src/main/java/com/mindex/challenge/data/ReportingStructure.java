package com.mindex.challenge.data;

public class ReportingStructure {
    //private String employeeId;
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){
    }

    // *** will use one of these in the end
    public String getEmployeeId(){
        //return employeeId;
        return employee.getEmployeeId();
    }

    public Employee getEmployee(){
        return employee;
    }
    // ***

    //public void setEmployeeId(String employeeId){
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public int getNumOfReports(){
        return numberOfReports;
    }

    public void setNumOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
    }
}
