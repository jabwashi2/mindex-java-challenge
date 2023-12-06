package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {
    Employee employee;
    int salary;
    Date effectiveDate;

    public Compensation(){
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public Date getDate(){
        return effectiveDate;
    }

    public void setDate(Date effectiveDate){
        this.effectiveDate = effectiveDate;
    }
}
